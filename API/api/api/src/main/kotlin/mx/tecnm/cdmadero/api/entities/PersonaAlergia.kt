package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "\"Persona.Alergia\"")
open class PersonaAlergia {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Column(name = "descripcion", nullable = false, length = 250)
    open var descripcion: String? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_medicamento", nullable = false)
    open var idMedicamento: Medicamento? = null

    @Column(name = "fecha_deteccion", nullable = false)
    open var fechaDeteccion: LocalDate? = null
}