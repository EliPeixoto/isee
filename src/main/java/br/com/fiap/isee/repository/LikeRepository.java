package br.com.fiap.isee.repository;

import br.com.fiap.isee.entities.Like;
import br.com.fiap.isee.entities.Post;
import br.com.fiap.isee.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserAndPost(Users user, Post post);
    long countByPost(Post post);
}
