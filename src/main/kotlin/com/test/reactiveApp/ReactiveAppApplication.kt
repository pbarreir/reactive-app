package com.test.reactiveApp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@SpringBootApplication
class ReactiveAppApplication

fun main(args: Array<String>) {
	runApplication<ReactiveAppApplication>(*args)
}

@Configuration
class Config {
	@Bean
	fun webClient(): WebClient = WebClient.create()
}

