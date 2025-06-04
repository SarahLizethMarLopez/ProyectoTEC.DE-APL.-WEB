package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.Medicamento
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MedicamentoRepository : JpaRepository<Medicamento, UUID> {
}