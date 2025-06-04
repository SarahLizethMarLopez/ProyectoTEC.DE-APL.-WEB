package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.ProcedimientosEnfermedad
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProcedimientosEnfermedadRepository : JpaRepository<ProcedimientosEnfermedad, UUID> {
}