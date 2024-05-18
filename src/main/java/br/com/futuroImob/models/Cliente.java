package br.com.futuroImob.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="clientes")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nome;

    @Column(unique = true, nullable = false)
    private String cpf;

    private String senha;

    @OneToMany(mappedBy = "cliente")
    private List<Imovel> imoveis;
}
