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
@Entity(name = "CuentaPuntosEntity")
@Table(name = "cuentapuntos")
public class CuentaPuntosEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codcpun")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "salcpun", nullable = false)
    private Integer saldo;

    @Column(name = "feccpun")
    private LocalDateTime fechaApertura;

    @Column(name = "codcli", nullable = false, unique = true)
    private Long codcli;

    @Column(name = "codniv", nullable = false)
    private Long codniv;

    @Column(name = "estcpun", nullable = false)
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
