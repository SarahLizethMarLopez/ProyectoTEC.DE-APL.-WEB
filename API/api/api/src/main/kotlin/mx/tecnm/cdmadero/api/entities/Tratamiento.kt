package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.hibernate.annotations.ColumnDefault
import java.util.*

@Entity
open class Tratamiento {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Column(name = "indicaciones", nullable = false, length = 250)
    open var indicaciones: String? = null

    @Column(name = "recomendaciones", nullable = false, length = 250)
    open var recomendaciones: String? = null
}