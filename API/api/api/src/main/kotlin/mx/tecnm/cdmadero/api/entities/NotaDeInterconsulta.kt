package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.time.Instant
import java.util.*

@Entity
@Table(name = "Nota_De_Interconsulta")
open class NotaDeInterconsulta {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Column(name = "criterios_de_diagnostico", nullable = false, length = 150)
    open var criteriosDeDiagnostico: String? = null

    @Column(name = "plan_de_estudios", nullable = false, length = 250)
    open var planDeEstudios: String? = null

    @Column(name = "sugerencias_diagnosticas", nullable = false, length = 250)
    open var sugerenciasDiagnosticas: String? = null

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tratamiento", nullable = false)
    open var idTratamiento: mx.tecnm.cdmadero.api.entities.Tratamiento? = null

    @Column(name = "fecha_hora", nullable = false)
    open var fechaHora: Instant? = null

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_signos_vitales", nullable = false)
    open var idSignosVitales: mx.tecnm.cdmadero.api.entities.SignosVitales? = null

    @Column(name = "motivo_de_atencion", nullable = false, length = 250)
    open var motivoDeAtencion: String? = null

    @Column(name = "resumen_interrogatorio", nullable = false, length = 550)
    open var resumenInterrogatorio: String? = null

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_exploracion_fisica", nullable = false)
    open var idExploracionFisica: ExploracionFisica? = null

    @Column(name = "estado_mental", nullable = false, length = 250)
    open var estadoMental: String? = null

    @Column(name = "resultados_relevantes_de_estudios", nullable = false, length = 250)
    open var resultadosRelevantesDeEstudios: String? = null

    @Column(name = "diagnostico", nullable = false, length = 150)
    open var diagnostico: String? = null

    @Column(name = "pronostico", nullable = false, length = 150)
    open var pronostico: String? = null
}