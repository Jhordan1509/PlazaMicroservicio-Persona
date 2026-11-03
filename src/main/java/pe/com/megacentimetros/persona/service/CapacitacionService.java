package pe.com.megacentimetros.persona.service;

import java.util.List;
import pe.com.megacentimetros.persona.entity.CapacitacionEntity;

public interface CapacitacionService {

	List<CapacitacionEntity> findAll();

	List<CapacitacionEntity> findAllCustom();

	CapacitacionEntity findById(Long id);

	CapacitacionEntity add(CapacitacionEntity obj);

	CapacitacionEntity update(CapacitacionEntity obj, Long id);

	CapacitacionEntity delete(Long id);

	CapacitacionEntity enable(Long id);
}
