package fr.rtransat.tvshowapp.application.controller

import fr.rtransat.tvshowapp.application.service.ActorService
import fr.rtransat.tvshowapp.application.viewmodel.ActorViewModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping(
    value = ["/v1/actors"],
    produces = [MediaType.APPLICATION_JSON_VALUE],
)
class ActorController(@Autowired val actorService: ActorService) {
    @GetMapping
    fun all(): MutableList<ActorViewModel> {
        val actorList = mutableListOf<ActorViewModel>()

        return actorService.findAll().mapTo(actorList) {
            return@mapTo ActorViewModel.fromDomain(it)
        }
    }

    // @todo return a json response when actor is not found
    @GetMapping("{uuid}")
    fun get(@PathVariable uuid: UUID): ActorViewModel? {
        return actorService.findByUuid(uuid)?.let {
            ActorViewModel.fromDomain(it)
        } ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Actor not found")
    }
}
