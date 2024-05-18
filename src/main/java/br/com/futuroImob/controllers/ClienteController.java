package br.com.futuroImob.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.futuroImob.*;
import br.com.futuroImob.dtos.ClienteCadastrarDTO;
import br.com.futuroImob.dtos.ClienteListarDTO;
import br.com.futuroImob.models.Cliente;
import br.com.futuroImob.services.ClienteService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ClienteListarDTO clienteListarDTO;


    @GetMapping
    public ResponseEntity<List<ClienteListarDTO>> listarClientes(){
        List<Cliente> clientes = clienteService.listarClientes();

        return ResponseEntity.status(HttpStatus.OK).body(
            clientes.stream()
            .map(cliente -> clienteListarDTO.converterClienteListarDTO(cliente))
            .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Object> salvarCliente(@RequestBody @Valid ClienteCadastrarDTO clienteCadastrarDTO){

        var cliente = new Cliente();
        BeanUtils.copyProperties(clienteCadastrarDTO, cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvarCliente(cliente));

    }
    
    
}
