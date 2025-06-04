package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.Direccion
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface DireccionRepository: JpaRepository<Direccion, UUID> {
}