package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.ColumnDefault
import java.util.*

@Entity
@Table(name = "Signos_Vitales")
open class SignosVitales {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Column(name = "temperatura_C", nullable = false)
    open var temperaturaC: Double? = null

    @Column(name = "tension_arterial_mmHg", nullable = false, length = 7)
    open var tensionArterialMmhg: String? = null

    @Column(name = "frecuencia_cardiaca_lat_min", nullable = false)
    open var frecuenciaCardiacaLatMin: Int? = null

    @Column(name = "frecuencia_respiratoria_rpm", nullable = false)
    open var frecuenciaRespiratoriaRpm: Int? = null
}