package cl.bci.creacion.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.bci.creacion.config.Constantes;
import cl.bci.creacion.config.GenerateJWT;
import cl.bci.creacion.exceptions.ServiceException;
import cl.bci.creacion.model.dto.Cliente;
import cl.bci.creacion.model.dto.ClientePhone;
import cl.bci.creacion.repository.ClienteRepository;
import cl.bci.creacion.repository.PhoneClienteRepository;

@Service
@Transactional
public class RegistroServiceImpl implements RegistroService {

	@Autowired
	private ClienteRepository clienteRepository;
	private GenerateJWT generarToken;
	private Cliente clienteResponse;
	@Autowired
	private PhoneClienteRepository phoneRepository;
	
	@Override
	public Cliente createCliente(Cliente cliente) throws ServiceException {
	    try {
	    	final String uuid = UUID.randomUUID().toString();

			cliente.setId(uuid);
			Date fecha = new Date();
			cliente.setCreated(fecha);
			cliente.setModified(fecha);
			cliente.setLast_login(fecha);
			cliente.setIsactive(Constantes.IS_ACTIVE);
			clienteResponse = clienteRepository.save(cliente);
			generarToken = new GenerateJWT();
			clienteResponse.setToken(generarToken.generarToken(cliente.getEmail(), cliente.getName(), cliente.getPassword()));
			
		} catch (Exception e) {
			 throw new ServiceException(e.toString());
		}
	    return clienteResponse;
	}

	@Override
	public List<Cliente> getAllCliente() {
		return this.clienteRepository.findAll();
	}

	@Override
	public ClientePhone createPhoneCliente(ClientePhone phones) {
		return phoneRepository.save(phones);
	}

	@Override
	public Cliente getClienteByEmail(String email) throws ServiceException {

			Optional<Cliente> clienteBd = this.clienteRepository.findById(email);
			if(clienteBd.isPresent()) {
				return clienteBd.get();
			}else {
				return null;
			}		
	}
}
