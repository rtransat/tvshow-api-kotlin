package fr.rtransat.tvshowapp.controller

import fr.rtransat.tvshowapp.entity.Actor
import fr.rtransat.tvshowapp.entity.Actors
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(
    value = ["/v1/actors"],
    produces = [MediaType.APPLICATION_JSON_VALUE],
)
class ActorController {
    companion object {
        fun fromRow(row: ResultRow) = Actor(
            uuid = row[Actors.uuid],
            name = row[Actors.name],
            active = row[Actors.active],
            created_at = row[Actors.created_at],
            updated_at = row[Actors.updated_at],
        )
    }

    @GetMapping
    fun all(): List<Actor> {
        return transaction { Actors.selectAll().orderBy(Actors.created_at to SortOrder.ASC).map { fromRow(it) } }
    }
}
