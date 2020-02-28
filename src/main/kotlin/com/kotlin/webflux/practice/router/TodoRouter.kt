package com.kotlin.webflux.practice.router

import com.kotlin.webflux.practice.handler.TodoHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates.path
import org.springframework.web.reactive.function.server.RouterFunctions.nest
import org.springframework.web.reactive.function.server.router

@Configuration
class TodoRouter (
        private val todoHandler: TodoHandler
){
    @Bean
    fun routerFunction() = nest(path("/todos"),
            router {
                listOf(
                        GET("/", todoHandler::getAll)
                )
            }
    )
}