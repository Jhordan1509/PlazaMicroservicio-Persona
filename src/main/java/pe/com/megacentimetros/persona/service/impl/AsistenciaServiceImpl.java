package pe.com.megacentimetros.persona.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.persona.client.CatalogoFeignClient;
import pe.com.megacentimetros.persona.entity.AsistenciaEntity;
import pe.com.megacentimetros.persona.repository.AsistenciaRepository;
import pe.com.megacentimetros.persona.service.AsistenciaService;

@Service
public class AsistenciaServiceImpl implements AsistenciaService {

	private AsistenciaRepository repositorio;
	private CatalogoFeignClient catalogoFeignClient;

	public AsistenciaServiceImpl(AsistenciaRepository repositorio,
			CatalogoFeignClient catalogoFeignClient) {
		this.repositorio = repositorio;
		this.catalogoFeignClient = catalogoFeignClient;
	}

	@Override
	public List<AsistenciaEntity> findAll() {
		List<AsistenciaEntity> lista = repositorio.findAll();
		for (AsistenciaEntity asistencia : lista) {
			asistencia.setEstadoasistencia(catalogoFeignClient.getEstadoAsistencia(asistencia.getCodeasis()));
		}
		return lista;
	}
	@Override
	public AsistenciaEntity findById(Long id) {
		AsistenciaEntity asistencia = repositorio.findById(id).get();
		asistencia.setEstadoasistencia(catalogoFeignClient.getEstadoAsistencia(asistencia.getCodeasis()));
		return asistencia;
	}
	@Override
	public AsistenciaEntity add(AsistenciaEntity obj) {
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}
	@Override
	public AsistenciaEntity update(AsistenciaEntity obj, Long id) {
		AsistenciaEntity objasi = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objasi, "codigo", "fechaCreacion", "usuarioCreacion");
		objasi.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objasi);
	}
	@Override
	public AsistenciaEntity delete(Long id) {
		AsistenciaEntity objasi = repositorio.findById(id).get();
		repositorio.delete(objasi);
		return objasi;
	}
}
