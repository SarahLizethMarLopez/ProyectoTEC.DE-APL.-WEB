package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.Instalacion
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface InstalacionRepository : JpaRepository<Instalacion, UUID> {
}