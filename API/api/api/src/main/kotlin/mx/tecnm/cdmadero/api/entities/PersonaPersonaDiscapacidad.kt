package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.*
import mx.tecnm.cdmadero.api.entities.keys.PersonaPersonaDiscapacidadId

@Entity
@Table(name = "\"Persona_Persona.Discapacidad\"")
open class PersonaPersonaDiscapacidad {
    @EmbeddedId
    open var id: PersonaPersonaDiscapacidadId? = null

    @MapsId("idPersona")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona", nullable = false)
    open var idPersona: Persona? = null

    @MapsId("idPersonaDiscapacidad")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona_discapacidad", nullable = false)
    open var idPersonaDiscapacidad: PersonaDiscapacidad? = null
}