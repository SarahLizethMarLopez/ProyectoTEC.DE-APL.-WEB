
package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.Persona
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*
import org.springframework.stereotype.Repository

interface PersonaRepository : JpaRepository<Persona, UUID> {
    fun findByCurp(curp: String): Persona?
    fun findByNss(nss: String): Persona?
}