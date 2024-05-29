package br.com.fiap.isee.repository;

import br.com.fiap.isee.entities.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepository extends JpaRepository<Tags, String> {
}
