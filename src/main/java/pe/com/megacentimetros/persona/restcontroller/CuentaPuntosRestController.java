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
import pe.com.megacentimetros.persona.entity.CuentaPuntosEntity;
import pe.com.megacentimetros.persona.service.CuentaPuntosService;

@RestController
@RequestMapping("/api/cuentapuntos")
public class CuentaPuntosRestController {

	@Autowired
	private CuentaPuntosService servicio;

	@GetMapping
	public List<CuentaPuntosEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<CuentaPuntosEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public CuentaPuntosEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public CuentaPuntosEntity add(@RequestBody CuentaPuntosEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public CuentaPuntosEntity update(@RequestBody CuentaPuntosEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public CuentaPuntosEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public CuentaPuntosEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
