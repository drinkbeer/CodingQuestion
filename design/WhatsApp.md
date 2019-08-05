WhatsApp is a instant messaging service allows users to send text messages to each other through Web and Mobile interface.

## Requirement

#### Functional Requirement
1. Send and Receive message
2. Chat history storage.
3. Group chating.
4. Online status.
5. Login and read contacts.
6. Multiple devices support.

#### Non-Functional Requirement
1. Read-time chatting.
2. High Reliable. No chat history/message lose.
3. High Availability.

## Analysis

#### Total Users & DAU
Total Users: 1B  
Daily Active User: 100M  

#### Write/Read TPS
Total messages wrote: 100M * 10 = 1B  
Write TPS: 1B / 86400 = 10K TPS

#### Storage
Assume 1 message is 30 bytes, total size one day:

1B * 30 bytes = 30 GB/day

#### Network
1B * 30 bytes / 86400 = 300 Kbps

#### Cache

## API Design

## Database Design

Message Table
```
PK  | msg_id:int
    | thread_id:int
    | from_user_id:int
    | to_user_id:int
    | content:varchar(300)
    | create_time:datetime
```

Thread Table
```
PK  | thread_id:int
    | owner_id:int
    | participant_ids:text
    | nickname: string
    | create_time:datetime
    | update_time:datetime
```

Message Table could be stored in NoSQL, as the message is mainly for read, and don't need update.

Thread Table use MySQL. We could index by 
* `owner_id + thread_id` (primary key which could be used for searching).
* `owner_id + updated_time` (make the thread order by update time descending.
NoSQL doesn't have good support for secondary index.


## High Level Design

## Detailed Design

#### Write Path

#### Read Path
