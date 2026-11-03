package pe.com.megacentimetros.persona.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "EmpleadoCapacitacionEntity")
@Table(name = "empleadocapacitacion")
@IdClass(EmpleadoCapacitacionId.class)
public class EmpleadoCapacitacionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codemp")
    private Long codemp;

    @Id
    @Column(name = "codcap")
    private Long codcap;

    @Column(name = "notecap", precision = 5, scale = 2)
    private BigDecimal nota;

    @Column(name = "codecap", nullable = false)
    private Long codecap;

    @Column(name = "feccomp")
    private LocalDate fechaCompletado;

    @Column(name = "usucre", length = 50, nullable = false)
    private String usuarioCreacion;

    @Column(name = "feccre", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "usuact", length = 50)
    private String usuarioActualizacion;

    @Column(name = "fecact")
    private LocalDateTime fechaActualizacion;
}
