# Micrometer Tracing

See https://itnext.io/opentelemetry-tracing-on-spring-boot-java-agent-vs-micrometer-tracing-a7710208fd63

Micrometer Tracing stems from Micrometer, a “vendor-neutral application observability facade”.

Micrometer Tracing started as an abstraction layer over Zipkin and Jaeger, and it made total sense. This argument
becomes moot with OpenTelemetry being supported by most libraries across programming languages and trace collectors.

Micrometer Tracing provides a simple facade for the most popular tracer libraries, letting you instrument your JVM-based
application code without vendor lock-in. It is designed to add little to no overhead to your tracing collection activity
while maximizing the portability of your tracing effort.

To start with Micrometer Tracing, one needs to add a few dependencies:

1. Spring Boot Actuator, org.springframework.boot:spring-boot-starter-actuator
2. Micrometer Tracing itself, io.micrometer:micrometer-tracing
3. A “bridge” to the target tracing backend API. In my case, it’s OpenTelemetry, hence io.micrometer:
   micrometer-tracing-bridge-otel
4. A concrete exporter to the backend, io.opentelemetry:opentelemetry-exporter-otlp

# OpenTelemetry Agent

See https://github.com/ajavageek/boot-tracing/tree/master/agent-2x
An alternative to Micrometer Tracing is the generic OpenTelemetry Java Agent. Its main benefit is that it impacts
neither the code nor the developers; the agent is a pure runtime-scoped concern.

```
java -javaagent:opentelemetry-javaagent.jar agent-one-1.0-SNAPSHOT.jar
```

# GOAL

This project uses Open Telemetry Collector to send traces to Zipkin.  
Original idea is from  
https://medium.com/@mertcakmak2/http-tracing-with-spring-boot-zipkin-and-open-telemetry-c12e4c599da4

# Logging correlation

The original idea is from  
https://medium.com/deno-the-complete-reference/spring-boot-3-2-logging-correlation-bc76216b616a

With 3.2, Spring Boot starts logging a correlation ID for all the logs relating to
one HTTP transaction as long as micrometer tracing is enabled. This behavior is ON by default.

# @NewSpan Annotation

This annotation changes the logging correlation id

```
[service1] [nio-8080-exec-1] [16065cb0d8c7640a1bb974f6b9a2af48-b4dfa45ea976a5d6] c.c.s.controller.PostController          : method1 is called
[service1] [nio-8080-exec-1] [16065cb0d8c7640a1bb974f6b9a2af48-8b9ca72fac055a3f] c.c.s.service.Service1                   : service1 begin
[service1] [nio-8080-exec-2] [16065cb0d8c7640a1bb974f6b9a2af48-e7a1d3fbb1dadb33] c.c.s.controller.PostController          : method2 is called
[service1] [nio-8080-exec-1] [16065cb0d8c7640a1bb974f6b9a2af48-8b9ca72fac055a3f] c.c.s.service.Service1                   : service1 end
```

Service1 has a new correlation because of @NewSpan Annotation

# ZIPKIN

Go to  
Visit: http://127.0.0.1:9411

# OTEL COLLECTOR HEALTH

Go to  
Visit:  http://127.0.0.1:13133

# Send

Go to   
http://localhost:8080/api/v1/service1/method1


