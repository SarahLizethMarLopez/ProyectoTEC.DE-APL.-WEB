package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.*
import mx.tecnm.cdmadero.api.entities.keys.PersonaPersonaAlergiaId

@Entity
@Table(name = "\"Persona_Persona.Alergia\"")
open class PersonaPersonaAlergia {
    @EmbeddedId
    open var id: PersonaPersonaAlergiaId? = null

    @MapsId("idPersona")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona", nullable = false)
    open var idPersona: Persona? = null

    @MapsId("idPersonaAlergia")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona_alergia", nullable = false)
    open var idPersonaAlergia: PersonaAlergia? = null
}