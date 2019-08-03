
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


