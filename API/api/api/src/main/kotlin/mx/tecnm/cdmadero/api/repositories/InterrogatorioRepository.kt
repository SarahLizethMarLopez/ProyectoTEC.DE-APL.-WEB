package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.Interrogatorio
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface InterrogatorioRepository : JpaRepository<Interrogatorio, UUID> {
}