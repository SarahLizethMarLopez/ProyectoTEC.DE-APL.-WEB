package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "Enfermedades_Degenerativas")
open class EnfermedadesDegenerativa {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Column(name = "nombre", nullable = false)
    open var nombre: String? = null

    @Column(name = "fecha_inicio")
    open var fechaInicio: LocalDate? = null

    @Column(name = "codigo_cie10", length = 10)
    open var codigoCie10: String? = null

    @Lob
    @Column(name = "descripcion")
    open var descripcion: String? = null
}