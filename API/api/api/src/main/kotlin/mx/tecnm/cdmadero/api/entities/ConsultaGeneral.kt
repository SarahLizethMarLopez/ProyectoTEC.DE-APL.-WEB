package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.time.Instant
import java.util.*

@Entity
@Table(name = "Consulta_General")
open class ConsultaGeneral {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona", nullable = false)
    open var idPersona: mx.tecnm.cdmadero.api.entities.Persona? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_personal_medico", nullable = false)
    open var idPersonalMedico: mx.tecnm.cdmadero.api.entities.PersonalMedico? = null

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_historia_clinica", nullable = false)
    open var idHistoriaClinica: mx.tecnm.cdmadero.api.entities.HistoriaClinica? = null

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_nota_de_evolucion", nullable = false)
    open var idNotaDeEvolucion: mx.tecnm.cdmadero.api.entities.NotaDeEvolucion? = null

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_nota_de_interconsulta", nullable = false)
    open var idNotaDeInterconsulta: mx.tecnm.cdmadero.api.entities.NotaDeInterconsulta? = null

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_nota_de_traslado", nullable = false)
    open var idNotaDeTraslado: mx.tecnm.cdmadero.api.entities.NotaDeReferenciaTraslado? = null

    @Column(name = "fecha_hora", nullable = false)
    open var fechaHora: Instant? = null
}