package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.PersonaDiscapacidad
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PersonaDiscapacidadRepository : JpaRepository<PersonaDiscapacidad, UUID> {
}