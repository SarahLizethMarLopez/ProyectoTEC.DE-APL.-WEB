package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.Cita
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CitaRepository: JpaRepository<Cita, UUID> {

}