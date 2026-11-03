package pe.com.megacentimetros.persona.service;

import java.util.List;
import pe.com.megacentimetros.persona.entity.AsistenciaEntity;

public interface AsistenciaService {

	List<AsistenciaEntity> findAll();

	AsistenciaEntity findById(Long id);

	AsistenciaEntity add(AsistenciaEntity obj);

	AsistenciaEntity update(AsistenciaEntity obj, Long id);

	AsistenciaEntity delete(Long id);
}
