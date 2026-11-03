package pe.com.megacentimetros.persona.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoCapacitacionId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long codemp;
    private Long codcap;
}
