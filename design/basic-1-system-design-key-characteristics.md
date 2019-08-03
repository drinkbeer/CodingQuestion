
# Key Characteristics

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

# Key Components

## Load Balancer

Load Balancer is used to spread the traffic across a cluster of servers to improve responsiveness and availability of applications, website or databases. LB can track the status of all resources while distributing the requests. If a server is not available to take new requests or is not responding or has elevated error rate, LB will stop sending traffic to it.




