
Sample project for demonstrating an issue with Spring Cloud Sleuth and Spring Cloud Gateway with missing OpenTracing span.


* To build:  `mvn clean verify`
* To run:  `mvn spring-boot:run`
* To test:  `curl http://localhost:8080`
* Expected result similar to:  `Active Span is brave.opentracing.BraveSpanContext$Complete@2358f18`


To recreate the problem:
* Uncomment the Spring Cloud Gateway dependency, re-build, and re-test.
* New result:  Active Span is null



(Not a contribution)
