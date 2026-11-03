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
import pe.com.megacentimetros.persona.entity.CapacitacionEntity;
import pe.com.megacentimetros.persona.service.CapacitacionService;

@RestController
@RequestMapping("/api/capacitacion")
public class CapacitacionRestController {

	@Autowired
	private CapacitacionService servicio;

	@GetMapping
	public List<CapacitacionEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<CapacitacionEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public CapacitacionEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public CapacitacionEntity add(@RequestBody CapacitacionEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public CapacitacionEntity update(@RequestBody CapacitacionEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public CapacitacionEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public CapacitacionEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
