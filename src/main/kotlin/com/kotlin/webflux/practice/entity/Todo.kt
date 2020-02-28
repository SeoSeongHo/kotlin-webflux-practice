package com.kotlin.webflux.practice.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Todo {
    @Id
    @GeneratedValue
    var id: Long = 0
    var content: String? = null
    var isSuccess: Boolean = false
    var create_datetime: LocalDateTime = LocalDateTime.now()
    var update_datetime: LocalDateTime = create_datetime
}