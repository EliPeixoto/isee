package br.com.fiap.isee.controller;

import br.com.fiap.isee.dto.PostDTO;
import br.com.fiap.isee.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("posts")
public class PostController {

    @Autowired
    private PostService service;

    @Operation(summary= "Retorna colecao de Posts", tags = "Posts")
    @GetMapping
    public ResponseEntity<Collection<PostDTO>> findAll(){
        var posts = service.findAll();
        return ResponseEntity.ok(posts);
    }

    @Operation(summary= "Retorna Posts pelo Id", tags = "Posts")
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable Long id){
        var post = service.findById(id);
        return ResponseEntity.ok(post);
    }

    @Operation(summary= "Cria novo Post", tags = "Posts")
    @PostMapping
    public ResponseEntity<PostDTO> save(@RequestBody PostDTO postDTO){
       postDTO = service.save(postDTO);
        return ResponseEntity.status(201).body(postDTO);
    }

    @Operation(summary= "Atualiza o Post passando o Id", tags = "Posts")
    @PutMapping("/{id}")
    public ResponseEntity<PostDTO>update(@PathVariable Long id, @RequestBody PostDTO postDTO){
        postDTO = service.update(id, postDTO);
        return ResponseEntity.ok(postDTO);
    }

    @Operation(summary= "Deleta o Post passando o ID", tags = "Posts")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}



