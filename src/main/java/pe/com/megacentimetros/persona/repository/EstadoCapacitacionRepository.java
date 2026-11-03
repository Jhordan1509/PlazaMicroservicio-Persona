package pe.com.megacentimetros.persona.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.persona.entity.EstadoCapacitacionEntity;

public interface EstadoCapacitacionRepository extends JpaRepository<EstadoCapacitacionEntity, Long> {

	@Query("select d from EstadoCapacitacionEntity d where d.estado = true")
	List<EstadoCapacitacionEntity> findAllCustom();
}
