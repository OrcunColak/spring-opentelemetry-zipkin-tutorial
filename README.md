# GOAL
This project uses Open Telemetry Collector to send traces to Zipkin.  
Original idea is from  
https://medium.com/@mertcakmak2/http-tracing-with-spring-boot-zipkin-and-open-telemetry-c12e4c599da4

# Logging correlation
The original idea is from  
https://medium.com/deno-the-complete-reference/spring-boot-3-2-logging-correlation-bc76216b616a  

With 3.2, Spring Boot starts logging a correlation ID for all the logs relating to 
one HTTP transaction as long as micrometer tracing is enabled. This behavior is ON by default. Output will be

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


