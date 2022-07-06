package com.test.reactiveApp

import org.springframework.data.mongodb.core.mapping.Document

@Document("users")
data class User(val name: String)