package br.com.fiap.isee.repository;

import br.com.fiap.isee.entities.Comments;
import br.com.fiap.isee.entities.Post;
import br.com.fiap.isee.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

   Optional<Comments> findByUserAndPost(Users user, Post post);

    long countByPost(Post post);
    List<Comments>findByPostId(Long postId);
}
