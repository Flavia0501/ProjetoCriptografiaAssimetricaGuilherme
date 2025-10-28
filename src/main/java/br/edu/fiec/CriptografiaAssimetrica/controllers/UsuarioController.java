package br.edu.fiec.CriptografiaAssimetrica.controllers;

import br.edu.fiec.CriptografiaAssimetrica.models.dtos.UsuarioDto;
import br.edu.fiec.CriptografiaAssimetrica.models.entities.Usuario;
import br.edu.fiec.CriptografiaAssimetrica.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody UsuarioDto usuarioDto) {
        usuarioService.create(usuarioDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "id", produces = APPLICATION_JSON_VALUE)
    public Usuario getUsuarioById(@RequestParam UUID id) {
        return usuarioService.getUsuarioById(id);
    }
}
