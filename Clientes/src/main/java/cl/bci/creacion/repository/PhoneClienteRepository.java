package cl.bci.creacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.bci.creacion.model.dto.ClientePhone;

public interface PhoneClienteRepository extends JpaRepository<ClientePhone, Long> {

}
