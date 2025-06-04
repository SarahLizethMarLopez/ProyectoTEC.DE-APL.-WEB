package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.DireccionEstado
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface DireccionEstadoRepository : JpaRepository<DireccionEstado, UUID> {
}