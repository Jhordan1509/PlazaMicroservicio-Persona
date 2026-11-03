package pe.com.megacentimetros.persona.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.megacentimetros.persona.entity.EstadoCapacitacionEntity;
import pe.com.megacentimetros.persona.service.EstadoCapacitacionService;

@RestController
@RequestMapping("/api/estadocapacitacion")
public class EstadoCapacitacionRestController {

	@Autowired
	private EstadoCapacitacionService servicio;

	@GetMapping
	public List<EstadoCapacitacionEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<EstadoCapacitacionEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public EstadoCapacitacionEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public EstadoCapacitacionEntity add(@RequestBody EstadoCapacitacionEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public EstadoCapacitacionEntity update(@RequestBody EstadoCapacitacionEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public EstadoCapacitacionEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public EstadoCapacitacionEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
