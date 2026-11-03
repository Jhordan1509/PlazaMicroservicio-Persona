package pe.com.megacentimetros.persona.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.persona.entity.CapacitacionEntity;
import pe.com.megacentimetros.persona.repository.CapacitacionRepository;
import pe.com.megacentimetros.persona.service.CapacitacionService;

@Service
public class CapacitacionServiceImpl implements CapacitacionService {

	private CapacitacionRepository repositorio;

	public CapacitacionServiceImpl(CapacitacionRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<CapacitacionEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<CapacitacionEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public CapacitacionEntity findById(Long id) {
		CapacitacionEntity capacitacion = repositorio.findById(id).get();
		return capacitacion;
	}
	@Override
	public CapacitacionEntity add(CapacitacionEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}
	@Override
	public CapacitacionEntity update(CapacitacionEntity obj, Long id) {
		CapacitacionEntity objcap = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objcap, "codigo", "fechaCreacion", "usuarioCreacion");
		objcap.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objcap);
	}
	@Override
	public CapacitacionEntity delete(Long id) {
		CapacitacionEntity objcap = repositorio.findById(id).get();
		objcap.setEstado(false);
		objcap.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objcap);
	}
	@Override
	public CapacitacionEntity enable(Long id) {
		CapacitacionEntity objcap = repositorio.findById(id).get();
		objcap.setEstado(true);
		objcap.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objcap);
	}
}
