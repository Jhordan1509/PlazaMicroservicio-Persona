package pe.com.megacentimetros.persona.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.persona.entity.EmpleadoEntity;

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long> {

	@Query("select d from EmpleadoEntity d where d.estado = true")
	List<EmpleadoEntity> findAllCustom();
}
