package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.PersonaAlergia
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PersonaAlergiaRepository : JpaRepository<PersonaAlergia, UUID> {
}