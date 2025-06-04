package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.util.*

@Entity
open class Medicacion {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tratamiento", nullable = false)
    open var idTratamiento: mx.tecnm.cdmadero.api.entities.Tratamiento? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_medicamento", nullable = false)
    open var idMedicamento: mx.tecnm.cdmadero.api.entities.Medicamento? = null

    @Column(name = "dosis", nullable = false, length = 50)
    open var dosis: String? = null

    @Column(name = "via_de_administracion", nullable = false, length = 50)
    open var viaDeAdministracion: String? = null

    @Column(name = "periodicidad", nullable = false, length = 50)
    open var periodicidad: String? = null
}