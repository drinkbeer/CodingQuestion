

## Requirement

#### Functional Requirement
1. User should be able to add/delete/update Places.
2. Given a location (longitude/latitude), users should be able to find all nearby places within a given radius.
3. Users should be able to add feedback/review about a place.

#### Non-Functional Requirement
1. Performance. Real-time location search with low latency.
2. High Reliable. No data lose.
3. High Availability. Low down time.

## Analysis

#### Total Users & DAU & Total Locations

Total Users: 500M  
DAU: 100M  
Total Locations:  500M

#### Write TPS

Assume 1% of DAU will add new locations, total Write in the service per day:  
100M * 1% = 1M  
Write TPS: 1M / 86400 = 10 TPS

#### Read TPS
Each User Query one time per day:

Total queries one day: 100M * 1 = 100M  
Read TPS: 100M / 86400 = 1K TPS

#### Storage


#### Network

#### Cache

## API Design

```
search(user_id, key_words, longitude, latitude, radius_filter, category_filter, maximum_result_returned, sort)
```

```
write(user_id, loc_name, longitude, latitude, category, description)
```

```
comment(user_id, loc_id, comments, stars)
```

## Database Design

Location Table
```
PK  | loc_id:varchar(8)
    | loc_name:varchar(30)
    | longitude:varchar(8)
    | latitude:varchar(8)
    | description:string
    |category:string
    | create_time:datetime
```

Each entity in the location table is: 100 bytes

Comment Table
```
PK  | comment_id:varcharr(8)
FK  | loc_id:varchar(8)
FK  | user_id:int
    | comment:string
    | rating:int
    | create_time:datetime
```

Size of one row: 300

User Table
```
PK  | user_id:int
    | user_name:varchar(8)
    | create_time:datetime
```

## High Level Design

## Detailed Design

#### Write Path

#### Read Path
