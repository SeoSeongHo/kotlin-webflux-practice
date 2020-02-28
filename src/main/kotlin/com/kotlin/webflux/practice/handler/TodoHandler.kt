package com.kotlin.webflux.practice.handler
import com.kotlin.webflux.practice.entity.Todo
import com.kotlin.webflux.practice.repository.TodoRepository
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.EntityResponse.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.notFound
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@Component
class TodoHandler (
        private val todoRepository: TodoRepository
){
    fun getById(req: ServerRequest): Mono<ServerResponse> = ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body<Todo>(Mono.justOrEmpty(todoRepository.findById(req.pathVariable("id").toLong())))
            .switchIfEmpty(notFound().build())
}