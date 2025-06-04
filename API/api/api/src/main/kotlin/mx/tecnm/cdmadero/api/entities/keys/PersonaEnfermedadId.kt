package mx.tecnm.cdmadero.api.entities.keys

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*

@Embeddable
open class PersonaEnfermedadId : Serializable {
    @Column(name = "id_persona", nullable = false)
    open var idPersona: UUID? = null

    @Column(name = "id_enfermedad", nullable = false)
    open var idEnfermedad: UUID? = null
    override fun hashCode(): Int = Objects.hash(idPersona, idEnfermedad)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as PersonaEnfermedadId

        return idPersona == other.idPersona &&
                idEnfermedad == other.idEnfermedad
    }

    companion object {
        private const val serialVersionUID = -3383161030930684940L
    }
}