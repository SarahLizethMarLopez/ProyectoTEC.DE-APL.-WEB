package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "Personal_Medico")
open class PersonalMedico {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, columnDefinition = "uniqueidentifier")
    var id: UUID? = null

    @Column(name = "cedula", nullable = false, length = 6)
    open var cedula: String? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_especialidad", nullable = false)
    open var idEspecialidad: mx.tecnm.cdmadero.api.entities.PersonalMedicoEspecialidad? = null

    @Column(name = "rol", nullable = false, length = 10)
    open var rol: String? = null

    @Column(name = "nombre", nullable=false, length = 50)
    open var nombre: String? = null

    @Column(name = "apellido_paterno", nullable=false, length = 20)
    open var apellidoPaterno: String? = null

    @Column(name = "apellido_materno", nullable=false, length = 20)
    open var apellidoMaterno: String? = null

    @Column(name = "curp", nullable=false, length = 18)
    open var curp: String? = null

    @Column(name = "fecha_nacimiento", nullable=false,)
    open var fechaNacimiento: LocalDate? = null

    @Column(name = "contrasena", nullable=false, length = 255)
    open var contrasena: String? = null

    @Column(name = "sexo", nullable=false, length = 1)
    open var sexo: Char? = null
}