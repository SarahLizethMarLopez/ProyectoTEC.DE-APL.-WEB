package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.Medicacion
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MedicacionRepository : JpaRepository<Medicacion, UUID> {
}