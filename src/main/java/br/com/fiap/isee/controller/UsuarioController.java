package br.com.fiap.isee.controller;

import br.com.fiap.isee.entities.Usuario;
import br.com.fiap.isee.service.UsuarioService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;
    @Autowired
    private HttpServletResponse httpServletResponse;

    @GetMapping
    public ResponseEntity<Collection<Usuario>> findAll() {
        var usuarios = service.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable UUID id) {
        var usuario = service.findById(id);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        usuario = service.save(usuario);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(usuario);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable UUID id, @RequestBody Usuario usuario) {
        usuario = service.update(id, usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
