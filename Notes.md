## show dependencies used and setup
- setup from scratch
- show how database connect from docker
- show benefit of docker compose

## Define Project Structure
- Order
- Inventory
- Payment

- prepopulate Inventory with Items

Order picks from Inventory
payment completes order

## Events
use events to communicate  @ApplicationModuleListener
keep track of failed and successful events
### Event Interface
- CompletedEventPublications
- IncompleteEventPublications

### Event Repository
- create model to mirror the already provided event_publication better management
- e.g the incompleteEventPublication does not have access to all uncompleted events
- we could write a stream/list around this in order to better manage

### properties
modulith:
republish-outstanding-events-on-restart: false  ## default
spring.modulith.events.jdbc-schema-initialization.enabled  ## not available

enable "spring.modulith.events.jdbc-schema-initialization.enabled" to create model structure
link model to entity


### exception handling
- use the feature in 1.2 called open_modules so it is shared in all classes
- upgrade the modulith version. probably the spring-boot-starter-modulith or check the (3.3.0)
