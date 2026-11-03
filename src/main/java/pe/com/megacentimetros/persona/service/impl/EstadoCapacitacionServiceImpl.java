package pe.com.megacentimetros.persona.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.persona.entity.EstadoCapacitacionEntity;
import pe.com.megacentimetros.persona.repository.EstadoCapacitacionRepository;
import pe.com.megacentimetros.persona.service.EstadoCapacitacionService;

@Service
public class EstadoCapacitacionServiceImpl implements EstadoCapacitacionService {

	private EstadoCapacitacionRepository repositorio;

	public EstadoCapacitacionServiceImpl(EstadoCapacitacionRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<EstadoCapacitacionEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<EstadoCapacitacionEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public EstadoCapacitacionEntity findById(Long id) {
		EstadoCapacitacionEntity estadoCapacitacion = repositorio.findById(id).get();
		return estadoCapacitacion;
	}
	@Override
	public EstadoCapacitacionEntity add(EstadoCapacitacionEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}
	@Override
	public EstadoCapacitacionEntity update(EstadoCapacitacionEntity obj, Long id) {
		EstadoCapacitacionEntity objest = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objest, "codigo", "fechaCreacion", "usuarioCreacion");
		objest.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objest);
	}
	@Override
	public EstadoCapacitacionEntity delete(Long id) {
		EstadoCapacitacionEntity objest = repositorio.findById(id).get();
		objest.setEstado(false);
		objest.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objest);
	}
	@Override
	public EstadoCapacitacionEntity enable(Long id) {
		EstadoCapacitacionEntity objest = repositorio.findById(id).get();
		objest.setEstado(true);
		objest.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objest);
	}
}
