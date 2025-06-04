package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.hibernate.annotations.ColumnDefault
import java.util.*

@Entity
open class Interrogatorio {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Column(name = "padecimiento_actual", nullable = false, length = 250)
    open var padecimientoActual: String? = null

    @Column(name = "antecedentes_heredo_familiares", nullable = false, length = 250)
    open var antecedentesHeredoFamiliares: String? = null

    @Column(name = "consumo_de_sustancias", nullable = false, length = 250)
    open var consumoDeSustancias: String? = null

    @Column(name = "dependencia_de_sustancias", nullable = false, length = 250)
    open var dependenciaDeSustancias: String? = null

    @Column(name = "\"otros_antecedentes_personales_patológicos\"", nullable = false, length = 250)
    open var otrosAntecedentesPersonalesPatológicos: String? = null

    @Column(name = "tratamientos_convencionales", nullable = false, length = 250)
    open var tratamientosConvencionales: String? = null

    @Column(name = "tratamientos_alternativos", nullable = false, length = 250)
    open var tratamientosAlternativos: String? = null

    @Column(name = "tratamientos_tradicionales", nullable = false, length = 250)
    open var tratamientosTradicionales: String? = null

    @Column(name = "otros_antecedentes_personales_no_patologicos", nullable = false, length = 250)
    open var otrosAntecedentesPersonalesNoPatologicos: String? = null

    @Column(name = "aparatos_y_sistemas", nullable = false, length = 250)
    open var aparatosYSistemas: String? = null
}