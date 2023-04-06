package fr.rtransat.tvshowapp.application.service

import fr.rtransat.tvshowapp.domain.entity.Actor
import fr.rtransat.tvshowapp.domain.repository.ActorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ActorService(@Autowired val repository: ActorRepository) {
    fun findByUuid(uuid: UUID): Actor? {
        return repository.findByUuid(uuid)
    }

    fun findAll(): List<Actor> {
        return repository.findAll()
    }

}
