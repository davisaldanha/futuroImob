package br.com.futuroImob.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
public class ClienteCadastrarDTO {

    @NotNull(message = "O nome não pode ser nulo.")
    @NotBlank(message = "O nome é obrigatório e não pode estar em branco.")
    private String nome;

    @NotNull(message = "O cpf não pode ser nulo.")
    @NotBlank(message = "O cpf é obrigatório e não pode estar em branco.")
    @Pattern(regexp = "^[0-9]{11}$", message = "O cpf deve ter 11 dígitos numéricos.")
    private String cpf;

    @NotNull(message = "O senha não pode ser nulo.")
    @NotBlank(message = "O senha é obrigatório e não pode estar em branco.")
    private String senha;
    
}
