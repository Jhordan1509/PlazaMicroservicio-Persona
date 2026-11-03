package pe.com.megacentimetros.persona.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.persona.entity.EmpleadoCapacitacionId;
import pe.com.megacentimetros.persona.entity.EmpleadoCapacitacionEntity;
import pe.com.megacentimetros.persona.repository.EmpleadoCapacitacionRepository;
import pe.com.megacentimetros.persona.service.EmpleadoCapacitacionService;

@Service
public class EmpleadoCapacitacionServiceImpl implements EmpleadoCapacitacionService {

	private EmpleadoCapacitacionRepository repositorio;

	public EmpleadoCapacitacionServiceImpl(EmpleadoCapacitacionRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<EmpleadoCapacitacionEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public EmpleadoCapacitacionEntity findById(Long codemp, Long codcap) {
		EmpleadoCapacitacionEntity empleadoCapacitacion = repositorio.findById(new EmpleadoCapacitacionId(codemp, codcap)).get();
		return empleadoCapacitacion;
	}
	@Override
	public EmpleadoCapacitacionEntity add(EmpleadoCapacitacionEntity obj) {
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		if (obj.getCodecap() == null) {
			obj.setCodecap(1L);
		}
		return repositorio.save(obj);
	}
	@Override
	public EmpleadoCapacitacionEntity update(EmpleadoCapacitacionEntity obj, Long codemp, Long codcap) {
		EmpleadoCapacitacionEntity objemp = repositorio.findById(new EmpleadoCapacitacionId(codemp, codcap)).get();
		BeanUtils.copyProperties(obj, objemp, "codemp", "codcap", "fechaCreacion", "usuarioCreacion");
		objemp.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objemp);
	}
	@Override
	public EmpleadoCapacitacionEntity delete(Long codemp, Long codcap) {
		EmpleadoCapacitacionEntity objemp = repositorio.findById(new EmpleadoCapacitacionId(codemp, codcap)).get();
		repositorio.delete(objemp);
		return objemp;
	}
}
