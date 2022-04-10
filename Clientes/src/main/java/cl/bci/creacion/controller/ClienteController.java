package cl.bci.creacion.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.bci.creacion.config.Constantes;
import cl.bci.creacion.exceptions.ServiceException;
import cl.bci.creacion.model.dto.Cliente;
import cl.bci.creacion.model.dto.ClientePhone;
import cl.bci.creacion.service.RegistroService;
import cl.bci.creacion.to.ClienteRequest;
import cl.bci.creacion.to.ClienteResponse;
import cl.bci.creacion.to.PhonesRequest;

@RestController
public class ClienteController {
	@Autowired
	private RegistroService registroServices;
	private Cliente cliente;
	private List<PhonesRequest> phoneRequest;
	private ClientePhone clientePhone;
	
	@GetMapping("/")
	public String hola() {
		return "Bienvenido a creacion de clientes BCI";
	}
	
	@PostMapping("/registro")
	public ResponseEntity<?> registro(@RequestBody ClienteRequest request) throws ServiceException, EntityNotFoundException {
		// Validaciones
		if(request.getEmail() == null) {
			return new ResponseEntity<>(new ClienteResponse(Constantes.PARAM_REQUERIDO_EMAIL), HttpStatus.BAD_REQUEST);
		}else {
			if (request.getEmail().matches(Constantes.REG_EXP_EMAIL)) {
				cliente = registroServices.getClienteByEmail(request.getEmail());
				if (cliente == null) {
					cliente = new Cliente();
					cliente.setEmail(request.getEmail());
					if(request.getName() == null) {
						return new ResponseEntity<>(new ClienteResponse(Constantes.PARAM_REQUERIDO_NOMBRE), HttpStatus.BAD_REQUEST);
					}else {
						cliente.setName(request.getName());
					}
					
					if(request.getPassword() == null) {
						return new ResponseEntity<>(new ClienteResponse(Constantes.PARAM_REQUERIDO_PASSWORD), HttpStatus.BAD_REQUEST);	
					}else {
						if(request.getPassword().matches(Constantes.REG_EXP_PASS)) {
							cliente.setPassword(request.getPassword());
						}else {
							return new ResponseEntity<>(new ClienteResponse(Constantes.PASS_NO_VALIDA), HttpStatus.BAD_REQUEST);
						}
					}
										
					if(cliente.getName().isEmpty() || cliente.getEmail().isEmpty() || cliente.getPassword().isEmpty()) {
						return new ResponseEntity<>(new ClienteResponse(Constantes.PARAM_REQUERIDO), HttpStatus.BAD_REQUEST);
						
					}else {
		//crear cliente
						cliente = registroServices.createCliente(cliente);
						if (cliente.getId() != null) {
							phoneRequest = request.getPhones();
							if(phoneRequest == null) {
								return new ResponseEntity<>(new ClienteResponse(Constantes.PARAM_REQUERIDO_PHONES), HttpStatus.BAD_REQUEST);
							}else {
								for (PhonesRequest phonesRequest : phoneRequest) {
									clientePhone = new ClientePhone();
									clientePhone.setNumber(phonesRequest.getNumber());
									clientePhone.setCitycode(phonesRequest.getCitycode());
									clientePhone.setContrycode(phonesRequest.getContrycode());
									clientePhone.setClienteId(cliente.getId());
									registroServices.createPhoneCliente(clientePhone);
								}
								ClienteResponse response = new ClienteResponse();
								response.setId(cliente.getId());
								response.setCreated(cliente.getCreated());
								response.setModified(cliente.getModified());
								response.setToken(cliente.getToken());
								response.setLast_login(cliente.getLast_login());
								response.setIsactive(cliente.getIsactive());
								response.setMensaje(Constantes.SUCCESS);
								return new ResponseEntity<>(response, HttpStatus.OK);
							}
						}else {
							return new ResponseEntity<>(new ClienteResponse(Constantes.ERROR_CREACION), HttpStatus.CONFLICT);
						}
					}
				}else {
					return new ResponseEntity<>(new ClienteResponse(Constantes.EMAIL_REGISTRADO), HttpStatus.PRECONDITION_FAILED);
				}
			}else {
				return new ResponseEntity<>(new ClienteResponse(Constantes.EMAIL_NO_VALIDO), HttpStatus.BAD_REQUEST);
			}
		}		
	}
	
	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> getAllCliente(){
		return ResponseEntity.ok().body(registroServices.getAllCliente());
	}
}
