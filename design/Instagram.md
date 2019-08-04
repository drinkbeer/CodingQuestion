
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

## High Level Design


## Detailed Design



