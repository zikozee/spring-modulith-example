COURSE NAME: Spring Modulith (Simplified)
## Monoliths vs Micro service
- advantages of each
- failure points of each
- how moduliths come in
  - show diagram

## show dependencies used and setup   ---->>> DONE
- setup from scratch
- show how database connect from docker
- show benefit of docker compose

- create a github issue for the above and push
- connect database withing intellij

## Define Project Structure
- show diagram of the project goal
- 
- video 1
  - Order
  - Inventory
  - Payment

- video 2
  - prepopulate Inventory with Items




Order picks from Inventory
payment completes order

Send email to address, listen and send email (just log)                    ******

## Events
use events to communicate  @ApplicationModuleListener
### Event Interface
- CompletedEventPublications
- IncompleteEventPublications

### processing incomplete events
- keep a cached table EventActionBean (EventAction, canonical Name) to store the event action to be performed 
  - against the canonical name event payload (called event_type in the event_pub table)
    -  e.g payment: com.zee.modulith.order.dto.PaymentDto
    -  e.g Email: com.zee.modulith.order.dto.EmailDto
      - DONE
  
- scan and load at startup to the table (move uncommited to new package[module])

- we can then keep an enum of event action
- using spring batch + scheduler or just scheduler,
  - we can read from the cached table using the event action to get the fully qualified name
  - which we can pass as predicate to resubmitIncompletePublications(Predicate<EventPublication> filter) method 
    - of incompleteEventTransactions
  - this way we can accurately filter the events we need and resubmit at a scheduled time
- use **MOMENTS** to trigger events instead of scheduler

### Event Repository
- keep track of failed and successful events
- create model to mirror the already provided event_publication better management
- e.g the incompleteEventPublication does not have access to all uncompleted events
- we could write a stream/list around this in order to better manage or for analysis


### properties
modulith:
republish-outstanding-events-on-restart: false  ## default
spring.modulith.events.jdbc-schema-initialization.enabled  ## not available

enable "spring.modulith.events.jdbc-schema-initialization.enabled" to create model structure
link model to entity

## Document Application Modules
See spring-modulith-docs  in target folder
- write connecting test, run the test and check
  - target/spring-modulith-docs

### exception handling  -->                    ******
- use the feature in 1.2.0-RC1 called open_modules so it is shared in all classes
- upgrade the modulith version. probably the spring-boot-starter-modulith or check the (3.3.0-SNAPSHOT)

##  Add Runtime support  -->                    ******
- Spring Modulith’s support for module initialization at application runtime.
- see -> https://docs.spring.io/spring-modulith/reference/runtime.html

## Production Ready Features  -->                    ******
- see https://docs.spring.io/spring-modulith/reference/production-ready.html
- http://localhost:8080/actuator/modulith

