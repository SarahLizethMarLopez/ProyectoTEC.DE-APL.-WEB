package mx.tecnm.cdmadero.api.entities.keys

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*

@Embeddable
open class PersonaPersonaAlergiaId : Serializable {
    @Column(name = "id_persona", nullable = false)
    open var idPersona: UUID? = null

    @Column(name = "id_persona_alergia", nullable = false)
    open var idPersonaAlergia: UUID? = null
    override fun hashCode(): Int = Objects.hash(idPersona, idPersonaAlergia)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as PersonaPersonaAlergiaId

        return idPersona == other.idPersona &&
                idPersonaAlergia == other.idPersonaAlergia
    }

    companion object {
        private const val serialVersionUID = -3556614876933011960L
    }
}