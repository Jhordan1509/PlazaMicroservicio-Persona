package pe.com.megacentimetros.persona.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.persona.entity.NivelFidelizacionEntity;

public interface NivelFidelizacionRepository extends JpaRepository<NivelFidelizacionEntity, Long> {

	@Query("select d from NivelFidelizacionEntity d where d.estado = true")
	List<NivelFidelizacionEntity> findAllCustom();
}
