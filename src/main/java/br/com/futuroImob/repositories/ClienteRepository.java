package br.com.futuroImob.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.futuroImob.models.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
    Optional<Cliente> findByCpf(String cpf);

}
