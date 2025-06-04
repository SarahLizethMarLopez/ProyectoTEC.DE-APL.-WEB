package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.util.*

@Entity
@Table(name = "\"Personal_Medico.Especialidad.Subespecialidad\"")
open class PersonalMedicoEspecialidadSubespecialidad {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Column(name = "nombre", nullable = false, length = 80)
    open var nombre: String? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_personal_medico_especialidad", nullable = false)
    open var idPersonalMedicoEspecialidad: PersonalMedicoEspecialidad? = null
}