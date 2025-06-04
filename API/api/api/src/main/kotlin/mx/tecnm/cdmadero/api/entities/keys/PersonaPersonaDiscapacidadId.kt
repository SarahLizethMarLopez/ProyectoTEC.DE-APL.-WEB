package mx.tecnm.cdmadero.api.entities.keys

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*

@Embeddable
open class PersonaPersonaDiscapacidadId : Serializable {
    @Column(name = "id_persona", nullable = false)
    open var idPersona: UUID? = null

    @Column(name = "id_persona_discapacidad", nullable = false)
    open var idPersonaDiscapacidad: UUID? = null
    override fun hashCode(): Int = Objects.hash(idPersona, idPersonaDiscapacidad)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as PersonaPersonaDiscapacidadId

        return idPersona == other.idPersona &&
                idPersonaDiscapacidad == other.idPersonaDiscapacidad
    }

    companion object {
        private const val serialVersionUID = 473577466732358845L
    }
}