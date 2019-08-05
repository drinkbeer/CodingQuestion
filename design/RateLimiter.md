
## Requirement

#### Functional Requirement
1. Limit the number of requests one user can send to an API within a Time Window. e.g. 15 requests per second
2. The APIs are accessible through a cluster, so the rate limiter should be considered across different servers.

#### Non-Functional Requirement
1. High Availabile. The Rate Limiter should always work to protect our services from overwhelming.
2. Rate Limiter should not introduce substantial latencies affecting customer experience.

## Analysis

#### Total Users & DAU

#### Write TPS

#### Read TPS

#### Storage

#### Network

#### Cache

## API Design

## Database Design

## High Level Design

## Detailed Design

#### Write Path

#### Read Path

