package pe.com.megacentimetros.persona.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.persona.entity.NivelFidelizacionEntity;
import pe.com.megacentimetros.persona.repository.NivelFidelizacionRepository;
import pe.com.megacentimetros.persona.service.NivelFidelizacionService;

@Service
public class NivelFidelizacionServiceImpl implements NivelFidelizacionService {

	private NivelFidelizacionRepository repositorio;

	public NivelFidelizacionServiceImpl(NivelFidelizacionRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<NivelFidelizacionEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<NivelFidelizacionEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public NivelFidelizacionEntity findById(Long id) {
		NivelFidelizacionEntity nivelFidelizacion = repositorio.findById(id).get();
		return nivelFidelizacion;
	}
	@Override
	public NivelFidelizacionEntity add(NivelFidelizacionEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}
	@Override
	public NivelFidelizacionEntity update(NivelFidelizacionEntity obj, Long id) {
		NivelFidelizacionEntity objniv = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objniv, "codigo", "fechaCreacion", "usuarioCreacion");
		objniv.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objniv);
	}
	@Override
	public NivelFidelizacionEntity delete(Long id) {
		NivelFidelizacionEntity objniv = repositorio.findById(id).get();
		objniv.setEstado(false);
		objniv.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objniv);
	}
	@Override
	public NivelFidelizacionEntity enable(Long id) {
		NivelFidelizacionEntity objniv = repositorio.findById(id).get();
		objniv.setEstado(true);
		objniv.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objniv);
	}
}
