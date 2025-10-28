package br.edu.fiec.CriptografiaAssimetrica.models.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

    private String nome;

    private String cpf;

    private Integer idade;

    private String endereco;

    private String telefone;

    private String profissao;

    private String email;

    private String senha;
}
