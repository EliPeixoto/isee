package br.com.fiap.isee.controller;

import br.com.fiap.isee.dto.PostDTO;
import br.com.fiap.isee.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping
    public ResponseEntity<Collection<PostDTO>> findAll(){
        var posts = service.findAll();
        return ResponseEntity.ok(posts);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id){
        var post = service.findById(id);
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public ResponseEntity<PostDTO> save(@RequestBody PostDTO postDTO){
       postDTO = service.save(postDTO);
        return ResponseEntity.status(201).body(postDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PostDTO>update(@PathVariable String id, @RequestBody PostDTO postDTO){
        postDTO = service.update(id, postDTO);
        return ResponseEntity.ok(postDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}



