package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.PersonalMedico
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PersonalMedicoRepository : JpaRepository<PersonalMedico, UUID> {
    fun findByCedulaAndContrasena(cedula: String, contrasena: String): PersonalMedico?
    fun findByCedula(cedula: String): PersonalMedico?

}