
Design a single host database.

## Raft Concensus Algorithm

#### What is Raft

Raft is a concensus algorithm that is designed to be easy understand. It's equivalent to Paxos in fault-tolerange and performance. The difference is that it's decomposed into relatively independent subproblems, and it cleanly addresses all major pieces needed for practical systems. 

Consensus means multiple servers in distributed environment agreeing on values. Once they reach a decision on a valuee, that decision is final. 

Consensus Problems Raft is going to solve:
* Unreliable Network
* Computer hardware problem
* Avoid involving people when inconsistency happened

What is a good concensus algorithm:
1. Consistency between participant state machine
2. Tolerant of failures of 1 more participants
3. Tolerant of unreliable network

## Design a Single Host High Reliable KV Store

```
2. Design a single host high consistency KV store

Some notes: the RAM is large enough to hold all <K, V>, but to make it high persistency, we have to periodically flush the data in to disk. We could assume the hardware are reliable (hard-driver will not broken). 

Solution:
We could store <K, V> as ConcurrentHashMap as it a multiple thread environment.
We could persistent the PUT logs in disk. And we split the disk into fixed sized blocks, e.g. 64 K, and we fill the logs into blocks. We always write a new log in a new block.

We also need persistent the snapshot of CHM into the disk periodically. We will write the snapshot into HDD sequencially in order to save the disk seeking time. So in order to make the CHM snapshot consistent to the live CMH, we have to creat a chck point for the CHM snapshot to record the start pointer and end pointer of the this snapshot.

We are creating the snapshot in HDD, what if the hard driver get filled by the snapshot? Using a circular snapshot writer, which will start from the beginning of the HDD when we reached the end of the HDD.

PUT(K, V) {
  file.write_log(new log(K, V));
  Map.put(K, V);
}

GET(K) {
  if (!map.consistKey(K)) {
    Throw NoSuchElementException(“No Key: “ + K);
  }
  return map.get(K);
}

Recover when the in-memory CHM crashed:
RECOVER() {
  Map map = file.read_snapshot(check_point);
  List<Log> lists = File.read_log(check_point);
  for (Log log : lists) {
    map.put(log.K, log.V);
  }
}

What if PUT is called by multiple-threads parallels? Will this cause inconsistency?
Yes. For instance,

thread 1  -  write log <K, a>
thread 2 - write log <K, b>
Thread 2 - map.put<K, b>
thread 1 - write log <K, a>

the result will be, Map.get(K) == a, but the logs will be ”K = a, K = b”, so the logs and Map is inconsistent. How to resolve it? Think about the implementation of ConcurrentHashMap, it’s adding locks to segment, rather than the whole map. Here we could use Striped Lock to lock a specific key we want to write.
For instance, we have 32 threads do PUT, and we create 32 Striped Locks, and put locks into a lock pool. When thread 1 is doing PUT to key K, it get a Striped Lock of K, and start PUT, and Logging. When thread 2 try to get lock in the meanwhile, it will find that the Striped Lock of K has already been locked, it will be blocked until thread 1 release the lock.

The updated version of PUT:
PUT(K, V) {
  stripe_lock.lock(K);
  Try {
    file.write_log(new log(K, V));
    Map.put(K, V);
  } finally {
    Stripe_lock.release();
  }
}
```

If the V is very large that we cannot hold in memory, how to design it?
```
We store V in disk sequentially. We store <K, Loc> in HashMap. As it's a KV store, HashMap could be very fast query a K exists or not.

But if it's a data storage engine, if we want the K query supports other operators like, ranged query "<=", ">=", "LIKE", it's better to use B-tree as Index algorithm.
More details: https://dev.mysql.com/doc/refman/5.5/en/index-btree-hash.html

```

## Reference
* https://www.jianshu.com/p/e70849987439
* https://soulmachine.gitbooks.io/system-design/cn/key-value-store.html
* Raft Concensus Algorithm: https://www.youtube.com/watch?v=vYp4LYbnnW8
