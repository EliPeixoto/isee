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

    public Post save(Post post) {
        if (post.getTags() != null) {
            post.getTags().forEach(tag -> tag.setPost(post));
        }
        return repository.save(post);
    }

    public Post update(UUID id, Post post){
        Post buscaPost = repository.getOne(id);
        buscaPost.setTitulo(post.getTitulo());
        buscaPost.setConteudo(post.getConteudo());
        buscaPost.setTags(post.getTags());
        buscaPost = repository.save(buscaPost);
        return buscaPost;
    }

    public void delete(UUID id){
        repository.deleteById(id);
    }
}
