package br.com.fiap.isee.repository;

import br.com.fiap.isee.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, String> {
}
