package com.test.reactiveApp

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.mongodb.repository.Tailable
import reactor.core.publisher.Flux

interface UserRepository: ReactiveMongoRepository<User, String> {

    @Tailable
    fun findAllByName(name: String): Flux<User>
}