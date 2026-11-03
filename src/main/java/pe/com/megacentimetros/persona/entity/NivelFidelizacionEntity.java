package pe.com.megacentimetros.persona.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@Entity(name = "NivelFidelizacionEntity")
@Table(name = "nivelfidelizacion")
public class NivelFidelizacionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codniv")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomniv", length = 30, nullable = false, unique = true)
    private String nombre;

    @Column(name = "minniv", nullable = false, unique = true)
    private Integer puntajeMinimo;

    @Column(name = "desniv", length = 300)
    private String descripcion;

    @Column(name = "estniv", nullable = false)
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
