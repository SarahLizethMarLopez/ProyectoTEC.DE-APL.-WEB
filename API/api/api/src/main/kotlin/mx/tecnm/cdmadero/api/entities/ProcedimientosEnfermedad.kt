package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "Procedimientos_Enfermedad")
open class ProcedimientosEnfermedad {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_enfermedad", nullable = false)
    open var idEnfermedad: EnfermedadesDegenerativa? = null

    @Column(name = "nombre_procedimiento", nullable = false)
    open var nombreProcedimiento: String? = null

    @Column(name = "fecha_procedimiento", nullable = false)
    open var fechaProcedimiento: LocalDate? = null

    @Lob
    @Column(name = "descripcion_procedimiento")
    open var descripcionProcedimiento: String? = null
}