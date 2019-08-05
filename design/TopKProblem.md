Design a system which returns the Top K heavy hitters. For example, find the 100 of the most searched keywords on google, the top 100 viewed videos on YouTube, 100 most played songs on Spotify, 100 most shares posts on Facebook, 100 most retweeted tweets on Twitter, 100 most liked photos on Instangram.

For these services, there are hundred of thousands of requests per second. We cannot use distributed cache or database to store the sorted data.

MapReduce is also not enough, as the requests are keep on going, the top 100 is updating very fast. And we need top 100 list for 1 minute, 5 minute, 15 minutes, 60 minutes.

## Requirement

#### Functional Requirement
1. Return the list of Top 100 shared links in the past 1 minute, 5 minutes, 15 minutes, 60 minutes.

#### Non-Functional Requirement
1. Scalable. It should be able to scale out together with increasing amount of data: videos, tweets, posts, etc.
2. Highly Available. It should be able to survive hardware/network failures, no single point of failure.
3. Highly Performant. few tens of milliseconds to return top 100 list.
4. Accurate: as accurate as we can get

## Analysis

#### Total Users & DAU

#### Write TPS

#### Read TPS

#### Storage

#### Network

#### Cache

## API Design

```
topK(k, start_time, end_time)
```
## Database Design

## High Level Design

A naive solution: 
Hashtable, singlehost

```
Input Data:
A B C A A D C A B C

Hashtable:
C: 3
D: 1
A: 4
B: 2

Use Heap:
Time: O(NlogK) - K is number of top K we required, N is total links
A: 4
C: 3

```
Single host solution is not scalable, and will become single point of failures.

A improved solution is to use multiple hosts to count frequency. It will be a huge hash table in memory.

![TopK.Basic.png](pic/TopK.Basic.png)

Algorithms:
1. Randomly partitioning data into Processor Hosts.
2. Each Processor Host collect the data, and get the TopK list in the host, and sort the list.
3. Pass the sorted TopK list to the Storage Host, and do a K-way merge, to get the final TopK. Time: O(KlogK).

This approach will have better scalability and throughput. Drawbacks:
1. Data set could be streaming data, and no boundary (means infinite). 
2. We need per 1 minutes TopK, 5 minute TopK, or even 1 hour TopK, we cannot store all the state in the memory of Processor Host. (We can assume that the memory of Processor Host can only hold 1 minute's data).

## Detailed Design

Analysis of the problem:
1. We need the whole data set in the particular time period (e.g. one day). But one day dateset is too large to hold in memory of a single host. Solution to this problem: store the dataset in disk, and only process one chunk of data in memory, get TopK of the chunk, and finally merge the TopK of all chunks to get the final TopK. This is the MapReduce counting idea.
2. The complexity of the solution. Every time we introduce data partitioning, we need to deal with data replication, so data in each partition are stored in multiple nodes.

#### How to count the number of each element in the data stream? Count-min sketch

![TopK.Count.Min.Sketch.png](pic/TopK.Count.Min.Sketch.png)





#### Write Path

#### Read Path



## Reference
* https://www.youtube.com/watch?v=kx-XDoPjoHw
