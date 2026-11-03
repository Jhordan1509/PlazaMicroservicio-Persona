package pe.com.megacentimetros.persona.service;

import java.util.List;
import pe.com.megacentimetros.persona.entity.CuentaPuntosEntity;

public interface CuentaPuntosService {

	List<CuentaPuntosEntity> findAll();

	List<CuentaPuntosEntity> findAllCustom();

	CuentaPuntosEntity findById(Long id);

	CuentaPuntosEntity add(CuentaPuntosEntity obj);

	CuentaPuntosEntity update(CuentaPuntosEntity obj, Long id);

	CuentaPuntosEntity delete(Long id);

	CuentaPuntosEntity enable(Long id);
}
