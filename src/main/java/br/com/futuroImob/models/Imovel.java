package br.com.futuroImob.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="imovel")
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String tipo;

    private String descricao;

    private String endereco;

    private String bairo;

    private String cidade;

    private BigDecimal valor;

    private LocalDate dataCadastro;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    
}
