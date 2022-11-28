# steps

there is two service: `producer` and `consumer`. 

`consumer` will call `producer` api, and it add resilience4j library. I expect when producer is down, consumer's circuit breaker will open and return fallback result. 

The key code is in `com.example.resilience4jcustomer.service.ProducerService`.

If I use spring `restTemplate`, when producer occur error, it will use fallback result.
But if I use other http library, it won't use fallback result.

I implement the two way code in `com.example.resilience4jcustomer.service.ProducerService`, you can start the two service, add call `http://localhost:8081/` by postman to validate it.