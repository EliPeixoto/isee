package br.com.fiap.isee.service;

import br.com.fiap.isee.controller.exception.ControllerBadRequestException;
import br.com.fiap.isee.dto.PostDTO;
import br.com.fiap.isee.entities.Post;
import br.com.fiap.isee.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Collection<PostDTO> findAll() {
        var posts = repository.findAll();
        return posts
                .stream()
                .map(this::toPostDTO)
                .collect(Collectors.toList());
    }

    public PostDTO findById(String id) {
        var posts = repository.findById(id).orElseThrow(() -> new ControllerBadRequestException("Post não encontrado!"));
        return toPostDTO(posts);
    }

    public PostDTO save(PostDTO postDTO) {
        Post post = toPost(postDTO);
        post = repository.save(post);

        return toPostDTO(post);
    }

    public PostDTO update(String id, PostDTO postDTO) {
        try {
            Post buscaPost = repository.getReferenceById(id);
            buscaPost.setTitulo(postDTO.titulo());
            buscaPost.setConteudo(postDTO.conteudo());
            buscaPost.setTags(postDTO.tags());
            buscaPost = repository.save(buscaPost);
            return toPostDTO(buscaPost);
        } catch (HttpClientErrorException.BadRequest e) {
            throw new ControllerBadRequestException("Post não encontrado!");
        }
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    private PostDTO toPostDTO(Post post) {
        return new PostDTO(
                post.getId(),
                post.getTitulo(),
                post.getConteudo(),
                post.getTags()

        );
    }

    private Post toPost(PostDTO postDTO) {
        return new Post(
                postDTO.id(),
                postDTO.titulo(),
                postDTO.conteudo(),
                postDTO.tags()
        );
    }
}
