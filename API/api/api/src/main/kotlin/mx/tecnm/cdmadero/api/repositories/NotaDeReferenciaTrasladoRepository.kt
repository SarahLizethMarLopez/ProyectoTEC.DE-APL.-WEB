package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.NotaDeReferenciaTraslado
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface NotaDeReferenciaTrasladoRepository : JpaRepository<NotaDeReferenciaTraslado, UUID> {
}