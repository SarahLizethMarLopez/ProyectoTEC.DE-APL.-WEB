package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.ColumnDefault
import java.util.*

@Entity
@Table(name = "Nota_De_Referencia_Traslado")
open class NotaDeReferenciaTraslado {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Column(name = "establecimento_que_envia", nullable = false, length = 50)
    open var establecimentoQueEnvia: String=""

    @Column(name = "establecimiento_receptor", nullable = false, length = 50)
    open var establecimientoReceptor: String=""

    @Column(name = "motivo_de_envio", nullable = false, length = 50)
    open var motivoDeEnvio: String = ""

    @Column(name = "impresion_diagnostica", nullable = false, length = 50)
    open var impresionDiagnostica: String=""

    @Column(name = "terapeutica_empleada", nullable = false, length = 50)
    open var terapeuticaEmpleada: String=""
}