package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.Persona
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PacienteRepository : JpaRepository<Persona, UUID> {
    fun findByCurp(curp: String): Optional<Persona>
}