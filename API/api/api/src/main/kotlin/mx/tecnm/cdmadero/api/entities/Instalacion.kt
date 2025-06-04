package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.util.*

@Entity
open class Instalacion {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Column(name = "nombre", nullable = false, length = 50)
    open var nombre: String? = null

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_direccion", nullable = false)
    open var idDireccion: Direccion? = null

    @Column(name = "tipo", nullable = false, length = 50)
    open var tipo: String? = null

    @Column(name = "capacidad", nullable = false)
    open var capacidad: Int? = null

    @Column(name = "personal", nullable = false)
    open var personal: Int? = null

    @Column(name = "clues", nullable = false, length = 5)
    open var clues: String? = null
}