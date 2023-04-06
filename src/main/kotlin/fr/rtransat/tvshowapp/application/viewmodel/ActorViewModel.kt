package fr.rtransat.tvshowapp.application.viewmodel

import com.fasterxml.jackson.annotation.JsonProperty
import fr.rtransat.tvshowapp.domain.entity.Actor
import java.util.*

data class ActorViewModel(
    val id: UUID,
    val name: String,
    val active: Boolean,
    @JsonProperty("created_at") val createdAt: String,
    @JsonProperty("updated_at") val updatedAt: String?
) {
    companion object {
        fun fromDomain(actor: Actor): ActorViewModel {
            return ActorViewModel(actor.uuid, actor.name, actor.active, actor.createdAt.toString(), actor.updatedAt?.toString())
        }
    }

}
