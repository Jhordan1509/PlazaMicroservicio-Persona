package pe.com.megacentimetros.persona.service;

import java.util.List;
import pe.com.megacentimetros.persona.entity.NivelFidelizacionEntity;

public interface NivelFidelizacionService {

	List<NivelFidelizacionEntity> findAll();

	List<NivelFidelizacionEntity> findAllCustom();

	NivelFidelizacionEntity findById(Long id);

	NivelFidelizacionEntity add(NivelFidelizacionEntity obj);

	NivelFidelizacionEntity update(NivelFidelizacionEntity obj, Long id);

	NivelFidelizacionEntity delete(Long id);

	NivelFidelizacionEntity enable(Long id);
}
