package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.ColumnDefault
import java.util.*

@Entity
@Table(schema = "dbo", name = "\"Persona.Tipo_Sanguineo\"")
open class PersonaTipoSanguineo {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Column(name = "tipo", nullable = false, length = 5)
    open var tipo: String? = null
}