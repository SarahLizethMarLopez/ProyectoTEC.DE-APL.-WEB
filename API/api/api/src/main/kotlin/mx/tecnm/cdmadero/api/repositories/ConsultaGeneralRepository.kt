package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.ConsultaGeneral
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ConsultaGeneralRepository: JpaRepository<ConsultaGeneral, UUID> {
    fun findAllByIdPersonalMedico_Cedula(cedula: String): List<ConsultaGeneral>
}