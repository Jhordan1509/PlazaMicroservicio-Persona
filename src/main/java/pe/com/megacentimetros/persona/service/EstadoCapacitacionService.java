package pe.com.megacentimetros.persona.service;

import java.util.List;
import pe.com.megacentimetros.persona.entity.EstadoCapacitacionEntity;

public interface EstadoCapacitacionService {

	List<EstadoCapacitacionEntity> findAll();

	List<EstadoCapacitacionEntity> findAllCustom();

	EstadoCapacitacionEntity findById(Long id);

	EstadoCapacitacionEntity add(EstadoCapacitacionEntity obj);

	EstadoCapacitacionEntity update(EstadoCapacitacionEntity obj, Long id);

	EstadoCapacitacionEntity delete(Long id);

	EstadoCapacitacionEntity enable(Long id);
}
