# spring-modulith-example

# dependencies explanation
- spring-boot-starter-data-jpa: for jpa things
- spring-boot-starter-web: http requests
- spring-modulith-starter-core: spring modulith core dependencies
- spring-modulith-starter-jpa: storing events using jpa
- spring-boot-docker-compose: to auto create compose.yaml for development 
- postgresql: database
- lombok: to remove boiler-plate


# Using interface from another module sub-package
- we need to use @NamedInterface https://docs.spring.io/spring-modulith/reference/fundamentals.html#modules.named-interfaces
- see package-info.java for both inventory.exposed and order package
## Test https://docs.spring.io/spring-modulith/reference/testing.html#bootstrap-modes
- a Bootstrap mode need to be used else the test will fail
- alternatively we can mock the bean it depends on