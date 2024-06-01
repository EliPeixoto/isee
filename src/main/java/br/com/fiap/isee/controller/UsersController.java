package br.com.fiap.isee.controller;

import br.com.fiap.isee.entities.Users;
import br.com.fiap.isee.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/usuarios")
public class UsersController {

    @Autowired
    private UsersService service;

    @Operation(summary= "Retorna todos usuarios cadsatrados", tags = "Users")
    @GetMapping
    public ResponseEntity<Collection<Users>> findAll() {
        var usuarios = service.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @Operation(summary= "Encontra um usuario passando o id", tags = "Users")
    @GetMapping("/{id}")
    public ResponseEntity<Users> findById(@PathVariable Long id) {
        var usuario = service.findById(id);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(usuario);
    }


    @Operation(summary= "Salva novo Usuario", tags = "Users")
    @PostMapping
    public ResponseEntity<Users> save(@RequestBody Users users) {
        users = service.save(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(users));
    }


    @Operation(summary= "Atualiza dados do usuario", tags = "Users")
    @PutMapping("/{id}")
    public ResponseEntity<Users> update(@PathVariable Long id, @RequestBody Users users) {
        users = service.update(id, users);
        return ResponseEntity.ok(users);
    }

    @Operation(summary= "Deleta um Usuario pelo id", tags = "Users")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
