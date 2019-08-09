
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

## Reference
* https://www.jianshu.com/p/e70849987439
* Raft Concensus Algorithm: https://www.youtube.com/watch?v=P9Ydif5_qvE
