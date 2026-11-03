package pe.com.megacentimetros.persona.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.megacentimetros.persona.entity.EmpleadoCapacitacionEntity;
import pe.com.megacentimetros.persona.entity.EmpleadoCapacitacionId;
public interface EmpleadoCapacitacionRepository extends JpaRepository<EmpleadoCapacitacionEntity, EmpleadoCapacitacionId> {
}
