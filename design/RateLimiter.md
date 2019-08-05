
## Requirement

#### Functional Requirement
1. Limit the number of requests one user can send to an API within a Time Window. e.g. 15 requests per second
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



## Detailed Design

#### Write Path

#### Read Path

