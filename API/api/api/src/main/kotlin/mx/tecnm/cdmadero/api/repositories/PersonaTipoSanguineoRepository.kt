package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.PersonaTipoSanguineo
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PersonaTipoSanguineoRepository : JpaRepository<PersonaTipoSanguineo, UUID> {
}