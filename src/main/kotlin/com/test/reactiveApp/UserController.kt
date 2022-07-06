package com.test.reactiveApp

import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("users")
class UserController(val userRepository: UserRepository) {

    @PostMapping
    fun createUser(@RequestBody user: User): Mono<User> = userRepository.save(user)


    @GetMapping(produces = ["application/stream+json"])
    fun listenUsers(@RequestParam name: String): Flux<User> = userRepository.findAllByName(name)


}