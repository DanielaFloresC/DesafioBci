package cl.bci.creacion.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import cl.bci.creacion.exceptions.ServiceException;
import cl.bci.creacion.model.dto.Cliente;
import cl.bci.creacion.model.dto.ClientePhone;

public interface RegistroService {
	List<Cliente> getAllCliente();
	Cliente createCliente (Cliente cliente) throws  ServiceException;
	ClientePhone createPhoneCliente (ClientePhone phones);
	Cliente getClienteByEmail(String email) throws EntityNotFoundException, ServiceException;
}
