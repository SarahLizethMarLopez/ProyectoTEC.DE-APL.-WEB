package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.PersonalMedicoEspecialidadSubespecialidad
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PersonalMedicoEspecialidadSubespecialidadRepository :
    JpaRepository<PersonalMedicoEspecialidadSubespecialidad, UUID> {
}