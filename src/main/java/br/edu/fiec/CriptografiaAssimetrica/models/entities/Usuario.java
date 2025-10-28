package br.edu.fiec.CriptografiaAssimetrica.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column
    private String nome;

    @Column(unique = true)
    private String cpf;

    @Column
    private Integer idade;

    @Column
    private String endereco;

    @Column
    private String telefone;

    @Column
    private String profissao;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    public Usuario(String nome, String cpf, Integer idade, String endereco, String telefone, String profissao, String email, String senha) {
        setNome(nome);
        setCpf(cpf);
        setIdade(idade);
        setEndereco(endereco);
        setTelefone(telefone);
        setProfissao(profissao);
        setEmail(email);
        setSenha(senha);
    }
}
