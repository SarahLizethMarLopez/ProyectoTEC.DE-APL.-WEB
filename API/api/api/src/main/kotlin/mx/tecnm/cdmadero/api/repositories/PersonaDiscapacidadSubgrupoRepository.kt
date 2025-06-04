package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.PersonaDiscapacidadSubgrupo
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PersonaDiscapacidadSubgrupoRepository : JpaRepository<PersonaDiscapacidadSubgrupo, UUID> {
}