package pe.com.megacentimetros.persona.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.persona.client.CatalogoFeignClient;
import pe.com.megacentimetros.persona.entity.SucursalEntity;
import pe.com.megacentimetros.persona.repository.SucursalRepository;
import pe.com.megacentimetros.persona.service.SucursalService;

@Service
public class SucursalServiceImpl implements SucursalService {

	private SucursalRepository repositorio;
	private CatalogoFeignClient catalogoFeignClient;

	public SucursalServiceImpl(SucursalRepository repositorio,
			CatalogoFeignClient catalogoFeignClient) {
		this.repositorio = repositorio;
		this.catalogoFeignClient = catalogoFeignClient;
	}

	@Override
	public List<SucursalEntity> findAll() {
		List<SucursalEntity> lista = repositorio.findAll();
		for (SucursalEntity sucursal : lista) {
			sucursal.setDistrito(catalogoFeignClient.getDistrito(sucursal.getCoddis()));
			sucursal.setEstadooperativo(catalogoFeignClient.getEstadoOperativo(sucursal.getCodeope()));
		}
		return lista;
	}
	@Override
	public List<SucursalEntity> findAllCustom() {
		List<SucursalEntity> lista = repositorio.findAllCustom();
		for (SucursalEntity sucursal : lista) {
			sucursal.setDistrito(catalogoFeignClient.getDistrito(sucursal.getCoddis()));
			sucursal.setEstadooperativo(catalogoFeignClient.getEstadoOperativo(sucursal.getCodeope()));
		}
		return lista;
	}
	@Override
	public SucursalEntity findById(Long id) {
		SucursalEntity sucursal = repositorio.findById(id).get();
		sucursal.setDistrito(catalogoFeignClient.getDistrito(sucursal.getCoddis()));
		sucursal.setEstadooperativo(catalogoFeignClient.getEstadoOperativo(sucursal.getCodeope()));
		return sucursal;
	}
	@Override
	public SucursalEntity add(SucursalEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}
	@Override
	public SucursalEntity update(SucursalEntity obj, Long id) {
		SucursalEntity objsuc = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objsuc, "codigo", "fechaCreacion", "usuarioCreacion");
		objsuc.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objsuc);
	}
	@Override
	public SucursalEntity delete(Long id) {
		SucursalEntity objsuc = repositorio.findById(id).get();
		objsuc.setEstado(false);
		objsuc.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objsuc);
	}
	@Override
	public SucursalEntity enable(Long id) {
		SucursalEntity objsuc = repositorio.findById(id).get();
		objsuc.setEstado(true);
		objsuc.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objsuc);
	}
}
