package pe.com.megacentimetros.persona.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.persona.entity.CuentaPuntosEntity;

public interface CuentaPuntosRepository extends JpaRepository<CuentaPuntosEntity, Long> {

	@Query("select d from CuentaPuntosEntity d where d.estado = true")
	List<CuentaPuntosEntity> findAllCustom();
}
