package com.example.demo;

import static org.springframework.http.MediaType.*;
import static org.springframework.web.reactive.function.BodyInserters.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import io.opentracing.Tracer;
import reactor.core.publisher.Mono;


@SpringBootApplication
public class DemoApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(final String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public RouterFunction<ServerResponse> helloWorld(final WebClient.Builder builder, final Tracer tracer) {
//		return route(GET("/hello"), request -> Mono.fromCallable(() -> "Active Span is " + tracer.activeSpan() + '\n')
		return route(GET("/hello"), request -> Mono.fromCallable(() -> "Hello World\n")
												   .doOnNext(next -> LOGGER.info("This is a log message"))
											   .flatMap(result -> ServerResponse.ok().contentType(TEXT_PLAIN).body(fromValue(result))));
	}
}
