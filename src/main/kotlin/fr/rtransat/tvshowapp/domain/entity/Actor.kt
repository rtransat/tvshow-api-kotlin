package fr.rtransat.tvshowapp.domain.entity

import kotlinx.datetime.LocalDateTime
import java.util.*

data class Actor(
    val uuid: UUID,
    val name: String,
    val active: Boolean,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?
) : Entity
