package com.kotlin.webflux.practice.repository

import com.kotlin.webflux.practice.entity.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long>