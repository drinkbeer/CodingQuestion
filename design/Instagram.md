
Instagram is a social networking service which enables users to upload and share photos and videos. Users can choose to share photos/videos publicly or privately. Anything publicly shared videos/photos can be seen by any other use, whereas privately shared content can only be accessed by a specified set of people. Instagram also allows useers to share through many other social networking platforms, e.g. Facebook, Twitter.

## Requirement

#### Functional Requirements

1. Users should be able to upload/download/view photos.
2. Users can perform searches based on photo/video titles.
3. Users can follow other users.
4. Users can follow other users.
5. The system should be able to generate and display a user's News Feed consistenting of top photos from all the people the user follows.

#### Non-Functional Requirrements
1. High Availability.
2. Reliability. Cannot lose customer data.
3. Performance: Low Latency and High Throughput.

Some other features are not considered in the design: adding tags to photos, searching photos on tags, commenting on photos, who to follow, etc.

## Design Consideration

1. Size Limitation of Photo? 10 MB. Average Size? 100 KB.
2. Size Limitatio of Videos? 500 MB. Avg Size? 10 MB.
3 Number of photos/videos has any limitation? No

## Analysis

#### Total Users and DAU

Total Users: 500 M  
Daily Active User: 100 M

#### Write TPS

Each DAU upload 1 Photo and 1 Video:
100M * 1 = 100M Photos total

100M / 86400 = 1K TPS

100M * 1 = 100M Videos total

100M / 86400 = 1K TPS

Total: 2K TPS write

#### Read TPS

Each DAU watch 10 photos, and 10 videos

100M * 10 = 1B Photos read

1B / 86400 = 10K TPS

100M * 10 = 1B Video read

1B / 86400 = 10K TPS

Total: 20K TPS read

#### Storage

Photos:

100M * 100 KB = 10B KB = 10 TiB / day

Videos:

100M * 10 MB = 1B MB = 1M GB = 1 PiB / day

One year, we need 370 PiB. We could use AWS S3 as object storage.

#### Network

1 PiB / 86400 = 11 Gbps

Peak will be 30 Gbps.

## API Design

#### Read Photo/Video

```
getPhotos(user_id, photo_id)
```

```
getVideos(user_id, video_id)
```

#### Write Photo/Video

```
putPhotos(user_id, expiration_data, public=False, desc=None)
```

```
putVideos(user_id, expiration_data, public=False, desc=None)
```

#### Search Phot/Video

```
searchPhoto(key_word)
```

```
searchVideo(key_word)
```

## Database Design

Some consideration for database design:
1. Store billions of metadata.
2. Each metadata is small.
3. Read is about 10x of write.

User Table

```
PK  | user_id: int
    | name: varchar(30)
    | email: varchar(30)
    | date_of_birth: date
    | creation_date: date
    | last_login: date
```

Relation Table:
```
PK  | user_id: int
PK  | user_id: int
```

Photo Table:
```
PK  | photo_id: int
    | photo_path: varchar(100)
    | photo_latitude: int
    | photo_longitude: int
    | user_latitude: int
    | user_longitude: int
    | creation_date: date
```

```
PK  | video_id: int
    | video_path: varchar(100)
    | video_latitude: int
    | video_longitude: int
    | user_latitude: int
    | user_longitude: int
    | creation_date: date
```

Metadata is recommended to store in SQL, like AWS RDS (MySQL), because we need to do Join. We could discuss the data base scale up plan in later section.

Videos and Photos could be stored in AWS S3.

## High Level Design


## Detailed Design

#### 1. Splitting APIs to independent WS
The Read Photo API, Write Photo API, Read Video API, Write Photo API, Search API have totally different load, so we prefer to split these APIs to different Web Servers, so we could scale up based on loads. We could also do special optimization for different APIs independently.

#### 2. Improve Reliability by introducing redundancy.

We could use AWS Cross-Region Replica (CRR) service to improve the reliability of Object Storage.

For metadata storage, we could use Database periodical backup to backup the database.

#### 3. How to generate global unique Photo ID? Using a independent KGS to generate auto-increment sequencial ID.
We could use a dedicated Key Generation Service (KGS) to generate base64 encoded key, which are 6 bytes. So totally 64^6 keys in key space. To avoid single point of failure, we could have two databases, one generate even keys, one generate odd keys.

LB -> KGS1 -> DB 1
 |
  --> KGS2 --> DB 2
 
 DB 1 only generate odd keys, DB 2 only generate even keys.
 
 We can put a LB in front of them to round robin to deal with downtime.
 
#### 4. With the global unique Photo ID, how could we do DB partition? Using Consistent Hashing.

Using Base64 encoding algorithm to encode DB servers, and global photo id. Assign the photo metadata to the nearest next node in the clockwise in the Hash Ring.

global unique id -> (encode) 6 bytes consistent hashing id in the ring

using the 6 bytes consistent hashing id to find the cloest DB server in clockwise in the hash ring, and store the metadata in the server.

#### How to handle hot user? A user uploads a large amount of photos and videos. 

We are using the global unique photo id KGS, and then do Consistent Hashing using Base64 algorithm, so the distirbution of photos are evenly. A single use has a lot of photos/videos will not affect the performance.

#### How to handle hot photos/videos? A video/photo has been visited by a large amount of people.

We could use a global cache system to cache hot videos/photos based on trends.

#### News Feed Genertion








