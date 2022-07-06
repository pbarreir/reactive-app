package com.test.reactiveApp

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

@RestController
class TestController(webClient: WebClient) {

    private val scheduler = Schedulers.newBoundedElastic(200, 500, "async-request")

    private val httpCall: Mono<String> =
        webClient.get()
        .uri("localhost:8090/tracking")
        .retrieve()
        .bodyToMono()

    @GetMapping("/blocking")
    fun callExternalServiceBlocking(): String? = httpCall.block()


    @GetMapping("async")
    fun callExternalServiceAsync(): Mono<String> = Mono.fromCallable{ httpCall.block()!! }.subscribeOn(scheduler)


    @GetMapping("/nonBlocking")
    fun callExternalServiceNonBlocking(): Mono<String> = httpCall;



}