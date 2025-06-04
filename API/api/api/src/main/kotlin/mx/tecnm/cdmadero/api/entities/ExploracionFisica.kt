package mx.tecnm.cdmadero.api.entities

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.util.*

@Entity
@Table(name = "Exploracion_Fisica")
open class ExploracionFisica {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Column(name = "habitus_exterior", nullable = false, length = 150)
    open var habitusExterior: String? = null

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_signos_vitales", nullable = false)
    open var idSignosVitales: mx.tecnm.cdmadero.api.entities.SignosVitales? = null

    @Column(name = "peso_kg", nullable = false)
    open var pesoKg: Double? = null

    @Column(name = "talla_cm", nullable = false)
    open var tallaCm: Double? = null

    @Column(name = "observaciones_cabeza", nullable = false, length = 150)
    open var observacionesCabeza: String? = null

    @Column(name = "observaciones_cuello", nullable = false, length = 150)
    open var observacionesCuello: String? = null

    @Column(name = "observaciones_torax", nullable = false, length = 150)
    open var observacionesTorax: String? = null

    @Column(name = "observaciones_abdomen", nullable = false, length = 150)
    open var observacionesAbdomen: String? = null

    @Column(name = "observaciones_miembros", nullable = false, length = 150)
    open var observacionesMiembros: String? = null

    @Column(name = "observaciones_genitales", nullable = false, length = 150)
    open var observacionesGenitales: String? = null

    @Column(name = "otras_observaciones", nullable = false, length = 250)
    open var otrasObservaciones: String? = null
}