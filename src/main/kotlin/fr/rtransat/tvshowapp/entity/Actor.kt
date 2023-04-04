package fr.rtransat.tvshowapp.entity

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.datetime
import java.util.*

data class Actor(val uuid: UUID, val name: String, val active: Boolean, val created_at: LocalDateTime, val updated_at: LocalDateTime?)

object Actors : Table() {
    val uuid = uuid("uuid").uniqueIndex()
    val name = varchar("name", length = 255)
    val active = bool("active")
    val created_at = datetime("created_at")
    val updated_at = datetime("updated_at")
}
