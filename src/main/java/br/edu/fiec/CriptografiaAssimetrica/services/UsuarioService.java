package br.edu.fiec.CriptografiaAssimetrica.services;


import br.edu.fiec.CriptografiaAssimetrica.models.dtos.UsuarioDto;
import br.edu.fiec.CriptografiaAssimetrica.models.entities.Usuario;
import br.edu.fiec.CriptografiaAssimetrica.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public void create(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario(
                usuarioDto.getNome(),
                usuarioDto.getCpf(),
                usuarioDto.getIdade(),
                usuarioDto.getEndereco(),
                usuarioDto.getTelefone(),
                usuarioDto.getProfissao(),
                usuarioDto.getEmail(),
                usuarioDto.getSenha());

        usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(UUID id) {
        return usuarioRepository.findById(id).orElse(null);
    }
}
