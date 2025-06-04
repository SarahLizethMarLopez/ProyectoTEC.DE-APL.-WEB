package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.time.Instant
import java.util.*

@Entity
open class Cita {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Column(name = "id_personal_medico", nullable = false)
    open var idPersonalMedico: UUID? = null

    @Column(name = "id_persona", nullable = false)
    open var idPersona: UUID? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_instalacion", nullable = false)
    open var idInstalacion: mx.tecnm.cdmadero.api.entities.Instalacion? = null

    @Column(name = "fecha_hora", nullable = false)
    open var fechaHora: Instant? = null
}