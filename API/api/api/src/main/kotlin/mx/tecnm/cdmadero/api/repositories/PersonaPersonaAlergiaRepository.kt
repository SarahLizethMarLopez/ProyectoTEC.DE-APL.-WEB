package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.PersonaPersonaAlergia
import mx.tecnm.cdmadero.api.entities.keys.PersonaPersonaAlergiaId
import org.springframework.data.jpa.repository.JpaRepository

interface PersonaPersonaAlergiaRepository : JpaRepository<PersonaPersonaAlergia, PersonaPersonaAlergiaId> {
}