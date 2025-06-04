package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.util.*

@Entity
open class Direccion {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Column(name = "calle", nullable = false, length = 50)
    open var calle: String? = null

    @Column(name = "numero_exterior", nullable = false, length = 7)
    open var numeroExterior: String? = null

    @Column(name = "numero_interior", nullable = false, length = 7)
    open var numeroInterior: String? = null

    @Column(name = "codigo_postal", nullable = false, length = 5)
    open var codigoPostal: String? = null

    @Column(name = "colonia", nullable = false, length = 50)
    open var colonia: String? = null

    @Column(name = "municipio", nullable = false, length = 50)
    open var municipio: String? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estado", nullable = false)
    open var idEstado: mx.tecnm.cdmadero.api.entities.DireccionEstado? = null
}