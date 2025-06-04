package mx.tecnm.cdmadero.api.repositories

import mx.tecnm.cdmadero.api.entities.EnfermedadesDegenerativa
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface EnfermedadesDegenerativaRepository : JpaRepository<EnfermedadesDegenerativa, UUID> {
}