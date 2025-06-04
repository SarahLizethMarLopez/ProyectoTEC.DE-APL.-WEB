package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.util.*

@Entity
@Table(name = "Instalacion_Personal_Medico")
open class InstalacionPersonalMedico {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_instalacion", nullable = false)
    open var idInstalacion: Instalacion? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_personal", nullable = false)
    open var idPersonal: mx.tecnm.cdmadero.api.entities.PersonalMedico? = null
}