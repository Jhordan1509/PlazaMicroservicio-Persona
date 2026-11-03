package pe.com.megacentimetros.persona.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@Entity(name = "SucursalEntity")
@Table(name = "sucursal")
public class SucursalEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codsuc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomsuc", length = 100, nullable = false, unique = true)
    private String nombre;

    @Column(name = "dirsuc", length = 200, nullable = false)
    private String direccion;

    @Column(name = "telsuc", length = 15)
    private String telefono;

    @Column(name = "dessuc", length = 300)
    private String descripcion;

    @Column(name = "coddis", nullable = false)
    private Long coddis;

    @Column(name = "codeope", nullable = false)
    private Long codeope;

    @Column(name = "estsuc", nullable = false)
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
    private Object estadooperativo;
}
