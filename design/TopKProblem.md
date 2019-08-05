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


## Detailed Design

#### Write Path

#### Read Path



## Reference
* https://www.youtube.com/watch?v=kx-XDoPjoHw
