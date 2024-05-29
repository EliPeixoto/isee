package br.com.fiap.isee.controller;

import br.com.fiap.isee.entities.Users;
import br.com.fiap.isee.service.UsersService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("usuarios")
public class UsersController {

    @Autowired
    private UsersService service;
    @Autowired
    private HttpServletResponse httpServletResponse;

    @GetMapping
    public ResponseEntity<Collection<Users>> findAll() {
        var usuarios = service.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> findById(@PathVariable String id) {
        var usuario = service.findById(id);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(usuario);
    }

    @PostMapping
    public ResponseEntity<Users> save(@RequestBody Users users) {
        users = service.save(users);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(users);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> update(@PathVariable String id, @RequestBody Users users) {
        users = service.update(id, users);
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
