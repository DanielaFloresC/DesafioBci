package cl.bci.creacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.bci.creacion.model.dto.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>  {

}
