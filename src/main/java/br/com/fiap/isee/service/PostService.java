package br.com.fiap.isee.service;

import br.com.fiap.isee.entities.Post;
import br.com.fiap.isee.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Collection<Post> findAll(){
        var posts = repository.findAll();
        return posts;
    }

    public Optional<Post> findById(UUID id){
        var posts = repository.findById(id);
        return posts;
    }

    public Post save(Post post){
    post = repository.save(post);
    return post;
    }

    public Post update(UUID id, Post post){
        Post buscaPost = repository.getOne(id);
        buscaPost.setNome(post.getNome());
        buscaPost.setDescricao(post.getDescricao());
        buscaPost.setUrlImage(post.getUrlImage());
        buscaPost.setCurtidas(post.getCurtidas());
        buscaPost = repository.save(buscaPost);
        return buscaPost;
    }

    public void delete(UUID id){
        repository.deleteById(id);
    }
}
