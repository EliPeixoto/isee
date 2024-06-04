package br.com.fiap.isee.service;

import br.com.fiap.isee.entities.Comments;
import br.com.fiap.isee.entities.Like;
import br.com.fiap.isee.entities.Post;
import br.com.fiap.isee.entities.Users;
import br.com.fiap.isee.repository.CommentsRepository;
import br.com.fiap.isee.repository.PostRepository;
import br.com.fiap.isee.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private PostRepository postRepository;




    public void commentsPost(Long userId, Long postId, String comentario){
        Users user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("Usuario não encontrado"));

        Post post = postRepository.findById((postId))
                .orElseThrow(()-> new RuntimeException("Post não encontrado"));

        Comments comments = new Comments(user, post, comentario);
        commentsRepository.save(comments);

    }

    public void descommentsPost(Long userId, Long postId){
        Users user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("Usuario nao encontrado"));
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new RuntimeException("Postagem não encontrada"));

        Comments comments = commentsRepository.findByUserAndPost(user, post)
                .orElseThrow(()->new RuntimeException("Curtida não encontrada"));
        commentsRepository.delete(comments);
    }

    public Long countComments(Long postId){
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new RuntimeException("Post não encontrado"));
        return commentsRepository.countByPost(post);
    }

    public List<Comments> getCommentsByPostId(Long postId) {
        return commentsRepository.findByPostId(postId);
    }

}
