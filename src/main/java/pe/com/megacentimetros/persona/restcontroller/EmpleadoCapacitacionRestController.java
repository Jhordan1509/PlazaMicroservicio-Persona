package pe.com.megacentimetros.persona.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.megacentimetros.persona.entity.EmpleadoCapacitacionEntity;
import pe.com.megacentimetros.persona.service.EmpleadoCapacitacionService;

@RestController
@RequestMapping("/api/empleadocapacitacion")
public class EmpleadoCapacitacionRestController {

	@Autowired
	private EmpleadoCapacitacionService servicio;

	@GetMapping
	public List<EmpleadoCapacitacionEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/{codemp}/{codcap}")
	public EmpleadoCapacitacionEntity findById(@PathVariable Long codemp, @PathVariable Long codcap) {
		return servicio.findById(codemp, codcap);
	}

	@PostMapping
	public EmpleadoCapacitacionEntity add(@RequestBody EmpleadoCapacitacionEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{codemp}/{codcap}")
	public EmpleadoCapacitacionEntity update(@RequestBody EmpleadoCapacitacionEntity obj, @PathVariable Long codemp, @PathVariable Long codcap) {
		return servicio.update(obj, codemp, codcap);
	}

	@DeleteMapping("/{codemp}/{codcap}")
	public EmpleadoCapacitacionEntity delete(@PathVariable Long codemp, @PathVariable Long codcap) {
		return servicio.delete(codemp, codcap);
	}
}
