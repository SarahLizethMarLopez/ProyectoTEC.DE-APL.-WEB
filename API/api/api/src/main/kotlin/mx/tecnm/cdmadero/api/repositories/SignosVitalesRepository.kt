package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.SignosVitales
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SignosVitalesRepository : JpaRepository<SignosVitales, UUID> {
}