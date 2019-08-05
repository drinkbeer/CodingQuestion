
## Requirement

#### Functional Requirement
1. Limit the number of requests one user can send to an API within a Time Window. e.g. 15 requests per second. `allowRequest(request)`
2. The APIs are accessible through a cluster, so the rate limiter should be considered across different servers.

#### Non-Functional Requirement
1. High Availabile. The Rate Limiter should always work to protect our services from overwhelming.
2. Rate Limiter should not introduce substantial latencies affecting customer experience.

## Analysis

#### Total Users & DAU

#### Write TPS

#### Read TPS

#### Storage

#### Network

#### Cache

## Some Concepts

#### Fix Window Algorithm

The sliding always starts from [0, 59] in one minutes.

For the following cases:

rate=2 per minute
```
00:40  : request 1
00:50  : request 2
01:10  : request 3
01:20  : request 4
01:40  : request 5
```
Using Fixed Window Algorithm, the request 1, 2, 3, 4 will all succeed, the request 5 will fail.

#### Rolling Window Algorithm
The window is counted as [curr_time - 60, curr_time]

rate=2 per minute
```
00:40  : request 1
00:50  : request 2
01:10  : request 3
01:20  : request 4
01:40  : request 5
```

Using rolling window algorithm, request 1, 2 will succeed, request 3, 4 will fail, request 5 will succeed.


## API Design

## Database Design

We are evicting the rate limiter information every sliding window, we could use Redis as data store.

## High Level Design

We could maintain the sliding window for each user using Redis. We use Sorted Set as our "value" field in the hash table.
```
Key   Value

user_id     sorted set<timestamp>
-------     ---------------------
Jason       <1564980270, 1564980271, 1564980273>
Kate        <1564980271, 1564980274>
```

Algorithm:

1. Query the user_id, and get the sorted set.
2. Remove all timestamps which is older than "current time - 1 minute" in the sorted set.
3. Get the size of the sorted set, if it's within the threshold, then insert curr timestamp into sorted set, and accept the request; otherwise, reject the request.

#### Storage Calculation
user_id: 8 bytes  
timestamp: 4 bytes  (we will have at most 60 timestamp in the sorted set)

So maintaining the sliding window, we need:

```
8 (user_id) + 4 * 60 (time stamp) + 20 (redis hashtable overhead) = 268 bytes
```

If it's one million user, the total size:

```
268 bytes * 1 M = 268 MB
```


## Detailed Design

If we want to keep track of requests counts for each user using multiple fixed time window. For instance, we have an hourly rate limiter, and we also have a rate limiter for one minute. For instance, hourly rate limiter is 500 requests/hour, minute rate limiter is 10 requests/minute, so one user cannot send more than 500 requests within one hour, and cannot send more than 10 requests per minute. 

```
Key   Value

user_id     hashmap<timestamp:count>
-------     ---------------------
Jason       <1564980270:1, 1564980271:3, 1564980273:3>
Kate        <1564980271:2, 1564980274:2>
```

We could use the following command to set the expiration of the HashMap to be one hour.

```
redis> EXPIRE <user_id> 3600
redis> TTL <user_id>
```

If we use the Fixed Sliding Window, then we don't update the expiration time of the entry when we update the timestamp. If we use the Rolling Sliding Window, we could update the expiration of the HashMap each time, and remove the timestamp that older than one hour by ourself. (as we are sure that the size of the hashmap is less than 3600, so the remove algorithm is quite efficient.)


## Reference
* https://www.youtube.com/watch?v=FU4WlwfS3G0
