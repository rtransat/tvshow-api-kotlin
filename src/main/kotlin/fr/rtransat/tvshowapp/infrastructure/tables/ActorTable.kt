package fr.rtransat.tvshowapp.infrastructure.tables

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object ActorTable : Table("actors") {
    val uuid = uuid("uuid").uniqueIndex()
    val name = varchar("name", length = 255)
    val active = bool("active")
    val created_at = datetime("created_at")
    val updated_at = datetime("updated_at")
}
