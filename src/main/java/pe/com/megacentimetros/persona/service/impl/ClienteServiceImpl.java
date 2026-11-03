package pe.com.megacentimetros.persona.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.persona.client.CatalogoFeignClient;
import pe.com.megacentimetros.persona.entity.ClienteEntity;
import pe.com.megacentimetros.persona.repository.ClienteRepository;
import pe.com.megacentimetros.persona.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	private ClienteRepository repositorio;
	private CatalogoFeignClient catalogoFeignClient;

	public ClienteServiceImpl(ClienteRepository repositorio,
			CatalogoFeignClient catalogoFeignClient) {
		this.repositorio = repositorio;
		this.catalogoFeignClient = catalogoFeignClient;
	}

	@Override
	public List<ClienteEntity> findAll() {
		List<ClienteEntity> lista = repositorio.findAll();
		for (ClienteEntity cliente : lista) {
			cliente.setDistrito(catalogoFeignClient.getDistrito(cliente.getCoddis()));
			if (cliente.getCodsex() != null) {
				cliente.setSexo(catalogoFeignClient.getSexo(cliente.getCodsex()));
			}
			cliente.setTipodocumento(catalogoFeignClient.getTipoDocumento(cliente.getCodtipd()));
			cliente.setTipocliente(catalogoFeignClient.getTipoCliente(cliente.getCodtcli()));
		}
		return lista;
	}
	@Override
	public List<ClienteEntity> findAllCustom() {
		List<ClienteEntity> lista = repositorio.findAllCustom();
		for (ClienteEntity cliente : lista) {
			cliente.setDistrito(catalogoFeignClient.getDistrito(cliente.getCoddis()));
			if (cliente.getCodsex() != null) {
				cliente.setSexo(catalogoFeignClient.getSexo(cliente.getCodsex()));
			}
			cliente.setTipodocumento(catalogoFeignClient.getTipoDocumento(cliente.getCodtipd()));
			cliente.setTipocliente(catalogoFeignClient.getTipoCliente(cliente.getCodtcli()));
		}
		return lista;
	}
	@Override
	public ClienteEntity findById(Long id) {
		ClienteEntity cliente = repositorio.findById(id).get();
		cliente.setDistrito(catalogoFeignClient.getDistrito(cliente.getCoddis()));
		if (cliente.getCodsex() != null) {
			cliente.setSexo(catalogoFeignClient.getSexo(cliente.getCodsex()));
		}
		cliente.setTipodocumento(catalogoFeignClient.getTipoDocumento(cliente.getCodtipd()));
		cliente.setTipocliente(catalogoFeignClient.getTipoCliente(cliente.getCodtcli()));
		return cliente;
	}
	@Override
	public ClienteEntity add(ClienteEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		if (obj.getFechaRegistro() == null) {
			obj.setFechaRegistro(LocalDateTime.now());
		}
		return repositorio.save(obj);
	}
	@Override
	public ClienteEntity update(ClienteEntity obj, Long id) {
		ClienteEntity objcli = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objcli, "codigo", "fechaCreacion", "usuarioCreacion", "fechaRegistro");
		objcli.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objcli);
	}
	@Override
	public ClienteEntity delete(Long id) {
		ClienteEntity objcli = repositorio.findById(id).get();
		objcli.setEstado(false);
		objcli.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objcli);
	}
	@Override
	public ClienteEntity enable(Long id) {
		ClienteEntity objcli = repositorio.findById(id).get();
		objcli.setEstado(true);
		objcli.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objcli);
	}
}
