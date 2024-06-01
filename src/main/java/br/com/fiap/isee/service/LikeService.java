package br.com.fiap.isee.service;

import br.com.fiap.isee.entities.Like;
import br.com.fiap.isee.entities.Post;
import br.com.fiap.isee.entities.Users;
import br.com.fiap.isee.repository.LikeRepository;
import br.com.fiap.isee.repository.PostRepository;
import br.com.fiap.isee.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public void likePost(Long userId, Long postId){
        Users user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("Usuario não encontrado"));
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new RuntimeException("Post não encontrado"));

        Optional<Like> likeExists = likeRepository.findByUserAndPost(user, post);
        if(likeExists.isPresent()){
            throw new RuntimeException("usuario ja curtiu esta postagem");
        }
        Like like = new Like(user, post);
        likeRepository.save(like);
    }


    public void deslikePost(Long userId, Long postId){
        Users user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("Usuario nao encontrado"));
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new RuntimeException("Postagem não encontrada"));

        Like like = likeRepository.findByUserAndPost(user, post)
                .orElseThrow(()->new RuntimeException("Curtida não encontrada"));
        likeRepository.delete(like);
    }

    public Long countLike(Long postId){
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new RuntimeException("Post não encontrado"));
        return likeRepository.countByPost(post);
    }
}
