package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.ExploracionFisica
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ExploracionFisicaRepository : JpaRepository<ExploracionFisica, UUID> {
}