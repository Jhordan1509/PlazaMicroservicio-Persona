package pe.com.megacentimetros.persona.service;

import java.util.List;
import pe.com.megacentimetros.persona.entity.EmpleadoEntity;

public interface EmpleadoService {

	List<EmpleadoEntity> findAll();

	List<EmpleadoEntity> findAllCustom();

	EmpleadoEntity findById(Long id);

	EmpleadoEntity add(EmpleadoEntity obj);

	EmpleadoEntity update(EmpleadoEntity obj, Long id);

	EmpleadoEntity delete(Long id);

	EmpleadoEntity enable(Long id);
}
