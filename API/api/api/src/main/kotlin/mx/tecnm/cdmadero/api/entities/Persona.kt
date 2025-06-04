package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.time.LocalDate
import java.util.*

@Entity
open class Persona {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Column(name = "nombre", nullable = false, length = 50)
    open var nombre: String? = null

    @Column(name = "apellido_paterno", nullable = false, length = 20)
    open var apellidoPaterno: String? = null

    @Column(name = "apellido_materno", nullable = false, length = 20)
    open var apellidoMaterno: String? = null

    @Column(name = "curp", nullable = false, length = 18)
    open var curp: String? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_sanguineo", nullable = false)
    open var idTipoSanguineo: mx.tecnm.cdmadero.api.entities.PersonaTipoSanguineo? = null

//    @Column(name = "grupo_etnico", nullable = false, length = 20)
//    open var grupoEtnico: String? = null

    @Column(name = "nss", nullable = false, length = 10)
    open var nss: String? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_direccion", nullable = false)
    open var idDireccion: Direccion? = null

    @Column(name = "fecha_nacimiento", nullable = false)
    open var fechaNacimiento: LocalDate? = null

    @Column(name = "institucion", nullable = false, length = 50)
    open var institucion: String? = null

//    @Column(name = "nivel_socioeconomico", nullable = false, length = 20)
//    open var nivelSocioeconomico: String? = null
//
//    @Column(name = "telefono", nullable = false, length = 10)
//    open var telefono: String? = null

//    @Column(name = "contrasena", nullable = false, length = 255)
//    open var contrasena: String? = null

    @Column(name = "sexo", nullable = false, length = 1)
    open var sexo: Char? = null
}