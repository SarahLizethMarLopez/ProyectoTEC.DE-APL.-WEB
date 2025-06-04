package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.hibernate.annotations.ColumnDefault
import java.util.*

@Entity
open class Institucion {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Column(name = "nombre", nullable = false, length = 50)
    open var nombre: String? = null
}