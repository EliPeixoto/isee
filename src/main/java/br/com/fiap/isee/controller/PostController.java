package br.com.fiap.isee.controller;

import br.com.fiap.isee.entities.Post;
import br.com.fiap.isee.service.PostService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/posts ")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping
    public ResponseEntity<Collection<Post>> findAll(){
        var posts = service.findAll();
        return ResponseEntity.ok(posts);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Post>> findById(@PathVariable UUID id){
        var post = service.findById(id);
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public ResponseEntity<Post>save(@RequestBody Post post){
        post = service.save(post);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(post);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Post>update(@PathVariable UUID id, @RequestBody Post post){
        post = service.update(id, post);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}



