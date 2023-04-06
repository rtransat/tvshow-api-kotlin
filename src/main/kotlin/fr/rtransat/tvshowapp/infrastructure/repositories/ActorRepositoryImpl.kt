package fr.rtransat.tvshowapp.infrastructure.repositories

import fr.rtransat.tvshowapp.domain.entity.Actor
import fr.rtransat.tvshowapp.domain.repository.ActorRepository
import fr.rtransat.tvshowapp.infrastructure.tables.ActorTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ActorRepositoryImpl : ActorRepository {
    companion object {
        fun fromRow(row: ResultRow) = Actor(
            uuid = row[ActorTable.uuid],
            name = row[ActorTable.name],
            active = row[ActorTable.active],
            createdAt = row[ActorTable.created_at],
            updatedAt = row[ActorTable.updated_at],
        )
    }

    override fun findByUuid(uuid: UUID): Actor? {
        return transaction { ActorTable.select { ActorTable.uuid eq uuid }.firstOrNull()?.let { fromRow(it) } }
    }
    override fun findAll(): List<Actor> {
        return transaction { ActorTable.selectAll().orderBy(ActorTable.created_at to SortOrder.ASC).map { fromRow(it) } }
    }
}
