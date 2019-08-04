Pastebin is a service enable users to store plain text or images over the network, and generate unique URLs to access the uploaded data.


## Requirements

#### Functional Requirements
1. User could "paste" their data, and get a unique URL to access it.
2. User could upload the text.
3. Data and links will expire automatically, and user could specify the expiration time.
4. User should optionally be able to pick a custom alias for their pate.

#### Non-Functional Requirements
1. Highly reliable, which means the data should not be lost.
2. High available. Percentage of time to be down should be low.
3. Efficiency. Low latency and high throughput.

#### Extended Requirements
1. Analytics. How many times a paste was accessed?
2. Provide RESTful API for otherr services.

## Design Consideration

1. Size limitation? We can limit the 'paste' data size less than 100 MB to stop abusing the service.
2. Should we support customized URL? Size limitation of the customized URL? Limitation of customized URL could be 30 bytes.

## Analysis

#### Daily Active User

DAU: 100 Million

#### Write TPS

Assume each user will write one paste bin.
100M * 1 / 86400 = 1K TPS

Peak is 3 times: 3K TPS

#### 
