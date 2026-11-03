package pe.com.megacentimetros.persona.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "AsistenciaEntity")
@Table(name = "asistencia")
public class AsistenciaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codasi")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "fecasi", nullable = false)
    private LocalDate fecha;

    @Column(name = "entasi")
    private LocalTime horaEntrada;

    @Column(name = "salasi")
    private LocalTime horaSalida;

    @Column(name = "codeasis", nullable = false)
    private Long codeasis;

    @Column(name = "codemp", nullable = false)
    private Long codemp;

    @Column(name = "usucre", length = 50, nullable = false)
    private String usuarioCreacion;

    @Column(name = "feccre", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "usuact", length = 50)
    private String usuarioActualizacion;

    @Column(name = "fecact")
    private LocalDateTime fechaActualizacion;

    @Transient
    private Object estadoasistencia;
}
