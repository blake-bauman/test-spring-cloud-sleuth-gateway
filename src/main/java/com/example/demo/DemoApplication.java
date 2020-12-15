package com.example.demo;

import static org.springframework.http.MediaType.*;
import static org.springframework.web.reactive.function.BodyInserters.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;

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

	public static void main(final String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public RouterFunction<ServerResponse> helloWorld(final WebClient.Builder builder, final Tracer tracer) {
		return route(GET("/hello"), request -> Mono.fromCallable(() -> "Active Span is " + tracer.activeSpan())
											   .flatMap(result -> ServerResponse.ok().contentType(TEXT_PLAIN).body(fromValue(result))));
	}
}
