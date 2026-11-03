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
@Entity(name = "ProveedorEntity")
@Table(name = "proveedor")
public class ProveedorEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codprov")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomprov", length = 50)
    private String nombres;

    @Column(name = "apepprov", length = 40)
    private String apellidoPaterno;

    @Column(name = "apemprov", length = 40)
    private String apellidoMaterno;

    @Column(name = "razprov", length = 150)
    private String razonSocial;

    @Column(name = "rucprov", length = 11, nullable = false, unique = true, columnDefinition = "CHAR(11)")
    private String ruc;

    @Column(name = "corprov", length = 100)
    private String correo;

    @Column(name = "telprov", length = 15)
    private String telefono;

    @Column(name = "celprov", length = 15)
    private String celular;

    @Column(name = "fecprov")
    private LocalDateTime fechaRegistro;

    @Column(name = "desprov", length = 300)
    private String descripcion;

    @Column(name = "dirprov", length = 200, nullable = false)
    private String direccion;

    @Column(name = "coddis", nullable = false)
    private Long coddis;

    @Column(name = "codeeva", nullable = false)
    private Long codeeva;

    @Column(name = "feceva")
    private LocalDate fechaEvaluacion;

    @Column(name = "estprov", nullable = false)
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
    private Object estadoevaluacion;
}
