package pe.com.megacentimetros.persona.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.persona.client.CatalogoFeignClient;
import pe.com.megacentimetros.persona.entity.EmpleadoEntity;
import pe.com.megacentimetros.persona.repository.EmpleadoRepository;
import pe.com.megacentimetros.persona.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	private EmpleadoRepository repositorio;
	private CatalogoFeignClient catalogoFeignClient;

	public EmpleadoServiceImpl(EmpleadoRepository repositorio,
			CatalogoFeignClient catalogoFeignClient) {
		this.repositorio = repositorio;
		this.catalogoFeignClient = catalogoFeignClient;
	}

	@Override
	public List<EmpleadoEntity> findAll() {
		List<EmpleadoEntity> lista = repositorio.findAll();
		for (EmpleadoEntity empleado : lista) {
			empleado.setDistrito(catalogoFeignClient.getDistrito(empleado.getCoddis()));
			empleado.setSexo(catalogoFeignClient.getSexo(empleado.getCodsex()));
			empleado.setTipodocumento(catalogoFeignClient.getTipoDocumento(empleado.getCodtipd()));
			empleado.setCargo(catalogoFeignClient.getCargo(empleado.getCodcarg()));
		}
		return lista;
	}
	@Override
	public List<EmpleadoEntity> findAllCustom() {
		List<EmpleadoEntity> lista = repositorio.findAllCustom();
		for (EmpleadoEntity empleado : lista) {
			empleado.setDistrito(catalogoFeignClient.getDistrito(empleado.getCoddis()));
			empleado.setSexo(catalogoFeignClient.getSexo(empleado.getCodsex()));
			empleado.setTipodocumento(catalogoFeignClient.getTipoDocumento(empleado.getCodtipd()));
			empleado.setCargo(catalogoFeignClient.getCargo(empleado.getCodcarg()));
		}
		return lista;
	}
	@Override
	public EmpleadoEntity findById(Long id) {
		EmpleadoEntity empleado = repositorio.findById(id).get();
		empleado.setDistrito(catalogoFeignClient.getDistrito(empleado.getCoddis()));
		empleado.setSexo(catalogoFeignClient.getSexo(empleado.getCodsex()));
		empleado.setTipodocumento(catalogoFeignClient.getTipoDocumento(empleado.getCodtipd()));
		empleado.setCargo(catalogoFeignClient.getCargo(empleado.getCodcarg()));
		return empleado;
	}
	@Override
	public EmpleadoEntity add(EmpleadoEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}
	@Override
	public EmpleadoEntity update(EmpleadoEntity obj, Long id) {
		EmpleadoEntity objemp = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objemp, "codigo", "fechaCreacion", "usuarioCreacion");
		objemp.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objemp);
	}
	@Override
	public EmpleadoEntity delete(Long id) {
		EmpleadoEntity objemp = repositorio.findById(id).get();
		objemp.setEstado(false);
		objemp.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objemp);
	}
	@Override
	public EmpleadoEntity enable(Long id) {
		EmpleadoEntity objemp = repositorio.findById(id).get();
		objemp.setEstado(true);
		objemp.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objemp);
	}
}
