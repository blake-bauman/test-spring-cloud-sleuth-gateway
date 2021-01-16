
Sample project for demonstrating an issue with Spring Cloud Sleuth and Spring Cloud Gateway with missing OpenTracing span.


* To build:  `mvn clean verify`
* To run:  `mvn spring-boot:run`
* To test:  `curl http://localhost:8080/foo`
* Response will be an error, but the server's log message for the `org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler` logger with the error will be:  `... [traceId=] [spanId=] - [0b4b7679-2]  500 Server Error for HTTP GET "/foo"`
* If you revert to previous release of Spring/SpringCloud:

```xml
		<version.spring>5.2.9.RELEASE</version.spring>
		<version.spring.boot>2.3.4.RELEASE</version.spring.boot>
		<version.spring.cloud.release.train>Hoxton.SR8</version.spring.cloud.release.train>
		<version.reactor.release.train>Dysprosium-SR12</version.reactor.release.train>
```
* Log message with error will be similar to:  `[traceId=157b5667cef9ead0] [spanId=157b5667cef9ead0] - [0b4b7679-2]  500 Server Error for HTTP GET "/foo"`


(Not a contribution)
