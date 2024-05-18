package br.com.futuroImob.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.futuroImob.models.Cliente;
import br.com.futuroImob.repositories.ClienteRepository;
import br.com.futuroImob.repositories.ImovelRepository;
import java.util.*;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ImovelRepository imovelRepository;


    @Transactional
    public Cliente salvarCliente(Cliente cliente){
        verificarCpfExistente(cliente.getCpf());
        return clienteRepository.save(cliente);
    }

    private void verificarCpfExistente(String cpf){
        Optional<Cliente> clienteExistente = clienteRepository.findByCpf(cpf);

        if(clienteExistente.isPresent()){
            throw new RuntimeException("Já existe um cliente cadastrado com este CPF.");
        }
    }

    @Transactional
    public void deletarCliente(Long id){
        Cliente cliente = clienteRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));

        if(!imovelRepository.findByCliente(cliente).isEmpty()){
            throw new RuntimeException("Não é possível deletar clientes associados a um imóvel");
        }

        clienteRepository.delete(cliente);
    }

    @Transactional
    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado){
        Cliente cliente = clienteRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
        
        if(!cliente.getCpf().equals(clienteAtualizado.getCpf())){
            throw new RuntimeException("Não é possível editar o CPF do cliente.");
        }

        return clienteRepository.save(cliente);
    }

    @Transactional
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }
}
