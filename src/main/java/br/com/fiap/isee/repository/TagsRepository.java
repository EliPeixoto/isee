package br.com.fiap.isee.repository;

import br.com.fiap.isee.entities.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends JpaRepository<Tags, Long> {
}
