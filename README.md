
Sample project for demonstrating an issue with Spring Cloud Gateway logs missing Sleuth trace data.


* To build:  `mvn clean verify`
* To run:  `mvn spring-boot:run`
* To test:  `curl http://localhost:8080/foo`
* Response will be an error, but the server's log messages for the request will be similar to:  `... [traceId=] [spanId=] - ..."`
* If you revert to previous release of Spring/SpringCloud:

```xml
		<version.spring>5.2.9.RELEASE</version.spring>
		<version.spring.boot>2.3.4.RELEASE</version.spring.boot>
		<version.spring.cloud.release.train>Hoxton.SR8</version.spring.cloud.release.train>
		<version.reactor.release.train>Dysprosium-SR12</version.reactor.release.train>
```
* Log messages for the request will be similar to:  `[traceId=157b5667cef9ead0] [spanId=157b5667cef9ead0] ..."`


(Not a contribution)
