package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.PersonalMedicoEspecialidad
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PersonalMedicoEspecialidadRepository : JpaRepository<PersonalMedicoEspecialidad, UUID> {
}