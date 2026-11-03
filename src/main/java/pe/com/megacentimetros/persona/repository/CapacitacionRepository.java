package pe.com.megacentimetros.persona.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.persona.entity.CapacitacionEntity;

public interface CapacitacionRepository extends JpaRepository<CapacitacionEntity, Long> {

	@Query("select d from CapacitacionEntity d where d.estado = true")
	List<CapacitacionEntity> findAllCustom();
}
