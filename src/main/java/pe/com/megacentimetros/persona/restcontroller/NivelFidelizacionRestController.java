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
import pe.com.megacentimetros.persona.entity.NivelFidelizacionEntity;
import pe.com.megacentimetros.persona.service.NivelFidelizacionService;

@RestController
@RequestMapping("/api/nivelfidelizacion")
public class NivelFidelizacionRestController {

	@Autowired
	private NivelFidelizacionService servicio;

	@GetMapping
	public List<NivelFidelizacionEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<NivelFidelizacionEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public NivelFidelizacionEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public NivelFidelizacionEntity add(@RequestBody NivelFidelizacionEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public NivelFidelizacionEntity update(@RequestBody NivelFidelizacionEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public NivelFidelizacionEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public NivelFidelizacionEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
