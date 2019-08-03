
## 1. SQL vs. NoSQL

**SQL** is relational database stores data in rows and columns. Each row contains all the information about one entity and each column contains all the separate data points. Some of the most popular relational database are MySQL, Oracle, MS SQL Server, SQLite, Postgres.

**NoSQL** includes:
1. Key-Value Store: data is stored in an array of key-value pairs. Well-known KV stores include Redis, DynamoDB.
2. Document Databases: data is stored in documents (instend of rows and columns in a table) and these documents are grouped together in collections. Each document can have an entirely different structure, like MongoDB, CouchDB.
3. Wide-Column Databases: Instead of 'tables', columnar databases have column families, which are containers for rows. Each row doesn't have the same number of columns. Columnar databases are best suited for analyzing large datasets - big names include Cassandra and HBase.
4. Graph Databases: Used to store data whose relations are best represented in a graph. Example of graph database include Neo4J and InfiniteGraph.

#### Difference between SQL and NoSQL

1. `Storage`: SQL stores data in tables where each row represents an entity and each column represents a data point about the entity. NoSQL has different storage model, like KV store, document store, graph, and columnar.
2. `Schema`: SQL has the same schema in each entity (row). The schema could be modified later, but it involves modifying the whole database and going offline. NoSQL's schema is dynamic.
3. `Querying`: SQL uses SQL (structured query language) for defining and manipulating the data, which is very powerful. In NoSQL, queries are focused on a collection of documents. Sometimes it is also called UnQL (Unstructured Query Language).
4. `Scalability`: In most common scenario, SQL databases are vertically scalable, e.g. by increasing the machine power (CPU, memory). It could also scale up vertically by dividing one big table into several small tables. It could scale up horizontally by split the rows into different machines. NoSQL is easy to do horizontal scale up by adding more servers. So we could just use check hardware to host NoSQL databases, and more cost effective. It's automatical.
5. `ACID (Atomicity, Consistency, Isolation, Durability) support`: Most SQL supports transactions. But most NoSQL doesn't support transaction. This is the major difference between SQL and NoSQL.

#### SQL vs. NoSQL

Reasons to use SQL:
1. Need support ACID.
2. Data to be stored is structured and unchanging.

Reasons to use NoSQL:
1. Storing large volumes of data that often has little or even no structure.
2. Fast change the data structure. NoSQL is extremely useful for a rapidi development when we need quick iterations of our system. We could update the data structure without a long downtime.
3. Easy horizontal scale up to make full use of CLoud Storage and Computing. Most NoSQL supports automatically horizontal scale up, in which case we could fully utilize the cloud computing and storage.

## 2. SQL Data Partitioning

Data Partitioning is the technique to break up a big database (DB) into many smaller parts. It is the process of splitting up a DB/table across multiple machines to improve the manageability, performance, availability, and local balancing of an application.

#### Partitioning Methods

a. Horizontal Partitioning: put different rows to different tables in different servers. For example, a range based partition could place ZIP code [0, 10000] rows into table 1, ZIP code [10001, 20000] into table 2. The range based partition must choose range carefully, otherwide it will cause unbalanced servers.

b. Vertical Partitioning: divide columns to different tables based on the features of the columns. For example, if we build an Instagram, we need to store data related to users, photos, people they followed. We can place usuer profile on one DB server, friend lists on another DB, photos on a third serveer. With the growth of our service, when there are more and more photos, we probably need to further partition photo tables.

c. Directory Based Partitioning: use a dedicated lookup service to store the partitioning schema and abstracts it away from the DB. So GET will look up in the lookup service to find the partition of the entity based on partitioning rule, and then do the query in DB.

#### Horizontal Partitioning Criteria

a. Hash-based partitioning: a simple approach is to calculate hash function based on key attributes in the entity, and get the partition number. For instance, we have 100 servers, we use `hash(entity) % 100` to get the partition number to determine which server to store the data. But once we change number of servers, it will require huge re-hashing load. Another approach is to use Consistent Hashing.

b. Pre-defined List based partition: we pre-define the rule of partitioning. For example, we make one rule <NorthAmerican, <US, Canada, Mexican>>, and <Asia, <China>>, <Asia2, <Japan, Koren>>, <Asia3, <India>>, and store the rules in a loop-up service.
