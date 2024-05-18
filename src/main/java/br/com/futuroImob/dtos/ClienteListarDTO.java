package br.com.futuroImob.dtos;

import org.springframework.stereotype.Component;

import br.com.futuroImob.models.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ClienteListarDTO {
    
    private Long id;
    private String nome;

    public ClienteListarDTO converterClienteListarDTO(Cliente cliente){

        var dto = new ClienteListarDTO();

        dto.setId(cliente.getCodigo());
        dto.setNome(cliente.getNome());

        return dto;
    }

    
}
