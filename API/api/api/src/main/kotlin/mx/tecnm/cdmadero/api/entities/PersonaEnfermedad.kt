package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.*
import mx.tecnm.cdmadero.api.entities.keys.PersonaEnfermedadId
import java.time.LocalDate

@Entity
@Table(name = "Persona_Enfermedad")
open class PersonaEnfermedad {
    @EmbeddedId
    open var id: PersonaEnfermedadId? = null

    @MapsId("idPersona")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona", nullable = false)
    open var idPersona: Persona? = null

    @MapsId("idEnfermedad")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_enfermedad", nullable = false)
    open var idEnfermedad: EnfermedadesDegenerativa? = null

    @Column(name = "fecha_diagnostico", nullable = false)
    open var fechaDiagnostico: LocalDate? = null
}