

## Requirement

#### Functional Requirement
!. Upload videos.
2. Watch videos.
3. Search based on video titles.
4. Record the stats of videos, e.g. like/dislike, total number of views, etc.
5. Comments on videos.

#### Non-Functional Requirement
1. High Reliable. Any uploaded videos should not be lost.
2. High Available. The percentage of down time should be small.
3. Performance. Low latency when watching videos.

#### Not in the scope of this design
Video recommendations, most popular videos, channels, subscriptions, watch later, favorite list, etc.

## Analysis

#### Total Users & DAU

Total Users: 1.5B  
DAU: 500 Million  

#### Write TPS

Percentage of DAU who upload 1 videos: 1%

Uploaded videos one day: 500M * 1% = 5 M  
Write TPS: 5M / 86400 = 50 videos/second

#### Read TPS

Each DAU watcvh 10 videos:

Watched videos one day: 500M * 10 = 5 B  
Read TPS: 5 B / 86400 = 50K TPS

#### Storage

Assume each video has 100 MB, total storage required one day:  
5M * 100 MB = 500 TB/day

#### Network
500 TB/day / 86400 = 5 Gbps

#### Cache
Assume 1% of videos are cached in CDN:

5B * 0.1% = 5M videos/day are cached.

## API Design

```
uploadVideo(user_id, video_title, video_description, categories, default_language, recording_details, video_contents)

api_dev_key (string): The API developer key of a registered account. This will be used to, among other things, throttle users based on their allocated quota.
video_title (string): Title of the video.
vide_description (string): Optional description of the video.
tags (string[]): Optional tags for the video.
category_id (string): Category of the video, e.g., Film, Song, People, etc.
default_language (string): For example English, Mandarin, Hindi, etc.
recording_details (string): Location where the video was recorded.
video_contents (stream): Video to be uploaded.
```

```
search(user_id, video_id, user_location, maximum_videos_to_return, page_token)

api_dev_key (string): The API developer key of a registered account of our service.
search_query (string): A string containing the search terms.
user_location (string): Optional location of the user performing the search.
maximum_videos_to_return (number): Maximum number of results returned in one request.
page_token (string): This token will specify a page in the result set that should be returned.
```

```
streamVideo(user_id, video_id, offset, codec, resolution)

api_dev_key (string): The API developer key of a registered account of our service.
video_id (string): A string to identify the video.
offset (number): We should be able to stream video from any offset; this offset would be a time in seconds from the beginning of the video. If we support playing/pausing a video from multiple devices, we will need to store the offset on the server. This will enable the users to start watching a video on any device from the same point where they left off.
codec (string) & resolution(string): We should send the codec and resolution info in the API from the client to support play/pause from multiple devices. Imagine you are watching a video on your TV’s Netflix app, paused it, and started watching it on your phone’s Netflix app. In this case, you would need codec and resolution, as both these devices have a different resolution and use a different codec.
```

## Database Design

Video Metadata Table
```
PK  | vid:int
    | title:varchar(30)
    | description:varchar(300)
    | size: int
    | thumbnail: string
FK  | user_id:int
    | loc_bucket: string
    | loc_filename: string
    | total_num_likes: int
    | total_num_dislikes: int
    | total_num_views: int
    | creation_time: datetime
```

Comment Table
```
PK  | comment_id: int
FK  | video_id: int
FK  | user_id: int
    | comment: string
    | creation_time: datetime
```

User Table
```
PK  | user_id: int
    | name: string
    | email: string
    | address: string
    | age: int
    | creation_time: datetime
```

## High Level Design

#### How will the videos stored? 
In distributed object storage system, like AWS S3 or HDFS.

#### How will metadata be stored?
Video metadata could be stored in MySQL or other relational database. We map the MySQL database to one chain in the Consistent Hashing Ring. We could encoding the database based on the global increment key using Base64 algorithm, and map the vid to one chain in the HashRing. Find the closest MySQL server in the clockwise in the Consistent Hashing Ring to store the metadata.

#### Some Components
1. Encoder: encode uploaded videos to different format.
2. Thumbnail generator: generate the thumbnail.
3. Video and Thumbnail Storage: store videos and Thumbnail in distributed object storage system.
4. User DB: just relational database
5. Video Metadata Database: using Relational Database, but sharding based on video id.


## Detailed Design

#### Split different APIs to different micro-services?
Splitting different APIs to different micro-services could help us scale up the APIs based on load.

#### We are using Key Generation Service to generate global unique keys, will this be single point of failures?
Yes. It's possible to be single point of failures. We make KGS to be master-slave mode. Once the master is down, the slave will take over the leadership. We have two database to generate auto-increment keys. One is for odd keys, another one is for even keys. So any of databases is down will not affect the whole services.

#### Encoding

We use a dedicated encoding services to encode the videos. We temporarily put the videos into Kafka, and waiting the encoding services to process it. 

#### Thumbnail

We use a dedicated thumbnail service to generate thumbnails, and put the job into Kafka. We will store the thumbnail into the AWS S3.


#### Search

When customer search based on video titles or description, we are likely to query the whole MySQL servers in the Consistent Hash Ring. Is there any better way to do this? I will suggest to use a dedicated Inverted Index Table (or Elastic Search), to store the titles and the video ids. When customer search, we search the table using the key words, and find the most relevant videos, and return the top relevant video list to customer.

ElasticSearch will aggregate the video titles/descriptions.

#### Write Path

#### Read Path
