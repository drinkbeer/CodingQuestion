
# 1. Key Characteristics

## Scalability

Scalability is the capability of a system, process, or a network to grow and manage increased demand. Increased demand could be increased number of requests, increased data volumes, etc.

#### Horizontal vs. Vertical Scaling

Horizontal scaling means that you scale by adding more servers into the pool of resources.  
Vertival scaling means that you scale by adding more power (CPU, RAM, Storage, etc.) to an existing server.  



## Availability vs. Reliability

Availability is the time a system remains operational to requests ina sppecific period of time. It's usually measured through percentage of time the system, service or a machine remains operational under normal conditions. But remember that, the account maintenance time, repair time, or other planned down time are all taken into account.

Reliability is the probability a system will fail in a given period. Remember that a distributed system is considered reliable in a scenario that part of the servers are down, but the overall system is able to process requests.


## Efficiency

We usually use the following two standard measures of system efficiency:

* Latency: response time of one request.
* Throughput: number of items delivered or number of bytes processed in a given time unit (e.g. a second).

# 2.Key Components

## Load Balancer

Load Balancer is used to spread the traffic across a cluster of servers to improve responsiveness and availability of applications, website or databases. LB can track the status of all resources while distributing the requests. If a server is not available to take new requests or is not responding or has elevated error rate, LB will stop sending traffic to it.

LB is helpful to scale services horizontally.

#### Benefit of Load Balancer
* User experience faster, uninterrupted service. Users won't have to wait for a single struggling server to finish the previous tasks.
* Service providers experience less downtime and higher throughput.
* Load balancing makes it easier for system administrators to handle incoming requests while decreasing wait time for users.

#### Load Balancer Algorithms

Load Balancer considers two factors before forwarding a request to a backend server. 
1. The server is actually responding appropriately to requests
2. Use a pre-configured algorithm to select one from the set of healthy servers.

Load Balancer could use 'heartbeat' request as health checks. Once a server fails to response the heartbeat, then LB removes this server from healthy server list.

Several algorithms are used to select servers from healthy server list:  
1. Least Connection Method - select the server with least connection.
2. Lease Response Time Method - select server with least connection and the lowest avarage response time.
3. Least Bandwidth Method - select the serveer that has least amount of traffic (measured by Mbps).
4. Round Robin Method - cycles all servers to a list, and select next server, if it reaches the end, just start from beginning of list.
5. Weighted Round Robin Method - This is used to process the servers with different capability. Each server is assigned a weight, and servers with higher weight will receive new connections before those with less weight, and servers with higher weight will receive more connections than those with less weight.
6. IP Hash - Calculate the hash partition based on IP address of client, and use the hash partition to determine which server to process the request.

## Caching

Caching helps to fully make use of existing resources.

Caches take advantage of the locality of reference principle: recently requested data is likely to be requested again. Caching is widely used in nearly every layer of computing: hardware, operating systems, web browsers, web applications, and more. A cache is like short-term memory: it has a limited amount of space, but is typically faster than the original data source and contains the most recently accessed items. Caches can exist at all levels in architecture, but are often found at the level nearest to the front end where they are implemented to return data quickly without a downstream request.

#### Cache in Web Server

Placing caches in Web Server will allow the Web Server quickly return local cached data if it exists. If it is not in the cache, it will query the data using downstream request.

If the Web Server is distributed, a local cache could have a lot of cache missing, and low effiency. We could either use: 1. Global Cache; 2. Distributed Cache.

#### Content Distribution Network (CDN)

CDN is a kind of cache for sites serving large amount of static media. In a typical scenario, a request will first ask the CDN for a piece of static media, the CDN will return the content if it has the content locally. If it isn't available, the CDN will query the back-end servers for the file, cache it locally, and return the content to user.

#### Cache Consistency

Cache contents must be consistent with the data store (e.g. database). Approaches to keep the cache consistent:

1. Write-through cache: PUT request will write to cache and data store at the same time. Also, this schema ensures that nothing will get lost in case of a crash, power failure, or other system disruptions. As PUT will write to both cache and data store, this schema will have higher latency.
2. Write-around cache: PUT request will write to data store directly. GET will read from cache, but there is 'cache miss', so read from data store, and write to cache, and then return to user. It will protect the cache from being flooded by a huge amount of write operations.
3. Write-back cache: PUT will write to cache along, and immediately return back to customer. There will be backend process to periodically write the cache to data store. This schema has low latency and high through-put, however, the speed comes with the risk of data loss in case of a crash or power outage. We could overcome the power outage by using Uninterruptted Data Supply (UPS).

#### Cache Eviction Policy
1. First In First Out (FIFO).
2. Last In First Out (LIFO).
3. Least Recently Used (LRU). Discard the least recently used item first.
4. Lease Frequently Used (LFU): Counts frequency of item being used, and discard the least frequently used item first.
5. Random Replacement (RR): Discard the randomly selected item.
