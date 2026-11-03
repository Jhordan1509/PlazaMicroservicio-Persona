package pe.com.megacentimetros.persona.service;

import java.util.List;
import pe.com.megacentimetros.persona.entity.EmpleadoCapacitacionEntity;

public interface EmpleadoCapacitacionService {

	List<EmpleadoCapacitacionEntity> findAll();

	EmpleadoCapacitacionEntity findById(Long codemp, Long codcap);

	EmpleadoCapacitacionEntity add(EmpleadoCapacitacionEntity obj);

	EmpleadoCapacitacionEntity update(EmpleadoCapacitacionEntity obj, Long codemp, Long codcap);

	EmpleadoCapacitacionEntity delete(Long codemp, Long codcap);
}
