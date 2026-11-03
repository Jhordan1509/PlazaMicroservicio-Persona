package pe.com.megacentimetros.persona.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.persona.client.CatalogoFeignClient;
import pe.com.megacentimetros.persona.entity.ProveedorEntity;
import pe.com.megacentimetros.persona.repository.ProveedorRepository;
import pe.com.megacentimetros.persona.service.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	private ProveedorRepository repositorio;
	private CatalogoFeignClient catalogoFeignClient;

	public ProveedorServiceImpl(ProveedorRepository repositorio,
			CatalogoFeignClient catalogoFeignClient) {
		this.repositorio = repositorio;
		this.catalogoFeignClient = catalogoFeignClient;
	}

	@Override
	public List<ProveedorEntity> findAll() {
		List<ProveedorEntity> lista = repositorio.findAll();
		for (ProveedorEntity proveedor : lista) {
			proveedor.setDistrito(catalogoFeignClient.getDistrito(proveedor.getCoddis()));
			proveedor.setEstadoevaluacion(catalogoFeignClient.getEstadoEvaluacion(proveedor.getCodeeva()));
		}
		return lista;
	}
	@Override
	public List<ProveedorEntity> findAllCustom() {
		List<ProveedorEntity> lista = repositorio.findAllCustom();
		for (ProveedorEntity proveedor : lista) {
			proveedor.setDistrito(catalogoFeignClient.getDistrito(proveedor.getCoddis()));
			proveedor.setEstadoevaluacion(catalogoFeignClient.getEstadoEvaluacion(proveedor.getCodeeva()));
		}
		return lista;
	}
	@Override
	public ProveedorEntity findById(Long id) {
		ProveedorEntity proveedor = repositorio.findById(id).get();
		proveedor.setDistrito(catalogoFeignClient.getDistrito(proveedor.getCoddis()));
		proveedor.setEstadoevaluacion(catalogoFeignClient.getEstadoEvaluacion(proveedor.getCodeeva()));
		return proveedor;
	}
	@Override
	public ProveedorEntity add(ProveedorEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		if (obj.getFechaRegistro() == null) {
			obj.setFechaRegistro(LocalDateTime.now());
		}
		return repositorio.save(obj);
	}
	@Override
	public ProveedorEntity update(ProveedorEntity obj, Long id) {
		ProveedorEntity objpro = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objpro, "codigo", "fechaCreacion", "usuarioCreacion", "fechaRegistro");
		objpro.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objpro);
	}
	@Override
	public ProveedorEntity delete(Long id) {
		ProveedorEntity objpro = repositorio.findById(id).get();
		objpro.setEstado(false);
		objpro.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objpro);
	}
	@Override
	public ProveedorEntity enable(Long id) {
		ProveedorEntity objpro = repositorio.findById(id).get();
		objpro.setEstado(true);
		objpro.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objpro);
	}
}
