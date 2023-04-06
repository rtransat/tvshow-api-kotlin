package fr.rtransat.tvshowapp.domain.repository

import fr.rtransat.tvshowapp.domain.entity.Actor
import java.util.*

interface ActorRepository: Repository<Actor, UUID> {
    fun findByUuid(uuid: UUID): Actor?
    fun findAll(): List<Actor>
}
