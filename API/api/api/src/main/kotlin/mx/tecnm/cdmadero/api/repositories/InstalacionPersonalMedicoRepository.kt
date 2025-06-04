package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.InstalacionPersonalMedico
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface InstalacionPersonalMedicoRepository : JpaRepository<InstalacionPersonalMedico, UUID> {
}