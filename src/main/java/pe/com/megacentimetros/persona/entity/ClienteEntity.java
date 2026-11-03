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
@Entity(name = "ClienteEntity")
@Table(name = "cliente")
public class ClienteEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codcli")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomcli", length = 50)
    private String nombres;

    @Column(name = "apepcli", length = 40)
    private String apellidoPaterno;

    @Column(name = "apemcli", length = 40)
    private String apellidoMaterno;

    @Column(name = "razcli", length = 150)
    private String razonSocial;

    @Column(name = "doccli", length = 20, nullable = false, unique = true)
    private String documento;

    @Column(name = "feccli")
    private LocalDateTime fechaRegistro;

    @Column(name = "naccli", length = 30)
    private String nacionalidad;

    @Column(name = "dircli", length = 200, nullable = false)
    private String direccion;

    @Column(name = "telcli", length = 15)
    private String telefono;

    @Column(name = "celcli", length = 15)
    private String celular;

    @Column(name = "corcli", length = 100, unique = true)
    private String correo;

    @Column(name = "descli", length = 300)
    private String descripcion;

    @Column(name = "coddis", nullable = false)
    private Long coddis;

    @Column(name = "codsex")
    private Long codsex;

    @Column(name = "codtipd", nullable = false)
    private Long codtipd;

    @Column(name = "codtcli", nullable = false)
    private Long codtcli;

    @Column(name = "estcli", nullable = false)
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
    private Object tipocliente;
}
