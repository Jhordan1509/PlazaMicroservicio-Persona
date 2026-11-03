package pe.com.megacentimetros.persona.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "CapacitacionEntity")
@Table(name = "capacitacion")
public class CapacitacionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codcap")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomcap", length = 100, nullable = false)
    private String nombre;

    @Column(name = "descap", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "inicap", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fincap", nullable = false)
    private LocalDate fechaFin;

    @Column(name = "horcap", nullable = false)
    private Integer horas;

    @Column(name = "estcap", nullable = false)
    private Boolean estado;

    @Column(name = "usucre", length = 50, nullable = false)
    private String usuarioCreacion;

    @Column(name = "feccre", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "usuact", length = 50)
    private String usuarioActualizacion;

    @Column(name = "fecact")
    private LocalDateTime fechaActualizacion;
}
