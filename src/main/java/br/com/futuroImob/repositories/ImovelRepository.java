package br.com.futuroImob.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.futuroImob.models.Cliente;
import br.com.futuroImob.models.Imovel;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long>{

    List<Imovel> findByCliente(Cliente cliente);
    
}
