package pe.com.megacentimetros.persona.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.megacentimetros.persona.entity.AsistenciaEntity;

public interface AsistenciaRepository extends JpaRepository<AsistenciaEntity, Long> {
}
