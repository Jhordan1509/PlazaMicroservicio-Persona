package pe.com.megacentimetros.persona.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.persona.entity.CuentaPuntosEntity;
import pe.com.megacentimetros.persona.repository.CuentaPuntosRepository;
import pe.com.megacentimetros.persona.service.CuentaPuntosService;

@Service
public class CuentaPuntosServiceImpl implements CuentaPuntosService {

	private CuentaPuntosRepository repositorio;

	public CuentaPuntosServiceImpl(CuentaPuntosRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<CuentaPuntosEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<CuentaPuntosEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public CuentaPuntosEntity findById(Long id) {
		CuentaPuntosEntity cuentaPuntos = repositorio.findById(id).get();
		return cuentaPuntos;
	}
	@Override
	public CuentaPuntosEntity add(CuentaPuntosEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		if (obj.getSaldo() == null) {
			obj.setSaldo(0);
		}
		if (obj.getFechaApertura() == null) {
			obj.setFechaApertura(LocalDateTime.now());
		}
		return repositorio.save(obj);
	}
	@Override
	public CuentaPuntosEntity update(CuentaPuntosEntity obj, Long id) {
		CuentaPuntosEntity objcue = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objcue, "codigo", "fechaCreacion", "usuarioCreacion", "fechaApertura");
		objcue.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objcue);
	}
	@Override
	public CuentaPuntosEntity delete(Long id) {
		CuentaPuntosEntity objcue = repositorio.findById(id).get();
		objcue.setEstado(false);
		objcue.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objcue);
	}
	@Override
	public CuentaPuntosEntity enable(Long id) {
		CuentaPuntosEntity objcue = repositorio.findById(id).get();
		objcue.setEstado(true);
		objcue.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objcue);
	}
}
