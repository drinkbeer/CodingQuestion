How to check friend, and friend of friend (2nd degree friend), and friend of friend of friend (3rd degree friend)? 
You are given a get_friends_lists() API, return a ascending sorted list of 1st degree friends.

Follow-up: how to improve efficiency of shared data?

## Requirement

#### Functional Requirement

#### Non-Functional Requirement

## Analysis

Friendship relationship is 

#### Total Users & DAU

#### Write TPS

#### Read TPS

#### Storage

#### Network

#### Cache

## API Design

## Database Design

## High Level Design

![GraphArchitectureDiagram.png](pic/GraphArchitectureDiagram.png)

* GraphDB: a KV database storing edges in the graph. It is horizontally scaled up, so that one member's entire adjacency list is stored in one physical node. It also has replicas.
* Network Cache Service (NCS): communicate with GraphDB to calculate 2nd degree distances. 80% of 2nd degree calls could be cached in the NCS.



## Detailed Design

#### Write Path

#### Read Path




## Reference
* https://engineering.linkedin.com/real-time-distributed-graph/using-set-cover-algorithm-optimize-query-latency-large-scale-distributed
* 
