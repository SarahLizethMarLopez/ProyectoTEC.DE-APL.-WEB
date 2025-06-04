package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.util.*

@Entity
@Table(name = "Nota_De_Evolucion")
open class NotaDeEvolucion {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Column(name = "evolucion", nullable = false, length = 250)
    open var evolucion: String? = null

    @Column(name = "actualizacion", nullable = false, length = 250)
    open var actualizacion: String? = null

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_signos_vitales", nullable = false)
    open var idSignosVitales: mx.tecnm.cdmadero.api.entities.SignosVitales? = null

    @Column(name = "resultados_reelevantes", nullable = false, length = 250)
    open var resultadosReelevantes: String? = null

    @Column(name = "diagnostico", nullable = false, length = 150)
    open var diagnostico: String? = null

    @Column(name = "pronostico", nullable = false, length = 150)
    open var pronostico: String? = null

    @Column(name = "indicaciones_medicas", nullable = false, length = 250)
    open var indicacionesMedicas: String? = null

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tratamiento", nullable = false)
    open var idTratamiento: mx.tecnm.cdmadero.api.entities.Tratamiento? = null
}