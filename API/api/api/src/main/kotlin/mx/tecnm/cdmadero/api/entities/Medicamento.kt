package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.hibernate.annotations.ColumnDefault
import java.util.*

@Entity
open class Medicamento {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Column(name = "nombre", nullable = false, length = 100)
    open var nombre: String? = null

    @Column(name = "descripcion", nullable = false, length = 250)
    open var descripcion: String? = null

    @Column(name = "cantidad", nullable = false, length = 10)
    open var cantidad: String? = null

    @Column(name = "unidad_medida", nullable = false, length = 10)
    open var unidadMedida: String? = null

    @Column(name = "presentacion", nullable = false, length = 10)
    open var presentacion: String? = null
}