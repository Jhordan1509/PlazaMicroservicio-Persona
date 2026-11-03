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
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "EmpleadoEntity")
@Table(name = "empleado")
public class EmpleadoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codemp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomemp", length = 50, nullable = false)
    private String nombres;

    @Column(name = "apepemp", length = 40, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apememp", length = 40, nullable = false)
    private String apellidoMaterno;

    @Column(name = "docemp", length = 20, nullable = false, unique = true)
    private String documento;

    @Column(name = "feccemp", nullable = false)
    private LocalDate fechaContratacion;

    @Column(name = "nacemp", length = 30, nullable = false)
    private String nacionalidad;

    @Column(name = "diremp", length = 200, nullable = false)
    private String direccion;

    @Column(name = "telemp", length = 15)
    private String telefono;

    @Column(name = "celemp", length = 15, nullable = false)
    private String celular;

    @Column(name = "coremp", length = 100, nullable = false, unique = true)
    private String correo;

    @Column(name = "desemp", length = 300)
    private String descripcion;

    @Column(name = "coddis", nullable = false)
    private Long coddis;

    @Column(name = "codsex", nullable = false)
    private Long codsex;

    @Column(name = "codtipd", nullable = false)
    private Long codtipd;

    @Column(name = "codcarg", nullable = false)
    private Long codcarg;

    @Column(name = "codsuc", nullable = false)
    private Long codsuc;

    @Column(name = "estemp", nullable = false)
    private Boolean estado;

    @Column(name = "usucre", length = 50, nullable = false)
    private String usuarioCreacion;

    @Column(name = "feccre", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "usuact", length = 50)
    private String usuarioActualizacion;

    @Column(name = "fecact")
    private LocalDateTime fechaActualizacion;

    @Transient
    private Object distrito;

    @Transient
    private Object sexo;

    @Transient
    private Object tipodocumento;

    @Transient
    private Object cargo;
}
