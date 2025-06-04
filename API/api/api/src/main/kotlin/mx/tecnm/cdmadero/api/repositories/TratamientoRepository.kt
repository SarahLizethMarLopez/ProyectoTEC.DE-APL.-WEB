package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.Tratamiento
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TratamientoRepository : JpaRepository<Tratamiento, UUID> {
}