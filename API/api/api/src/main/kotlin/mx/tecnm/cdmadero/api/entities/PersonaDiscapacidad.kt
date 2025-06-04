package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.util.*

@Entity
@Table(name = "\"Persona.Discapacidad\"")
open class PersonaDiscapacidad {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Column(name = "dicapacidad", nullable = false, length = 80)
    open var dicapacidad: String? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_subgrupo", nullable = false)
    open var idSubgrupo: mx.tecnm.cdmadero.api.entities.PersonaDiscapacidadSubgrupo? = null
}