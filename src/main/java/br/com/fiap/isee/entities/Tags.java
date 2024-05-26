package br.com.fiap.isee.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tb_tags")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "NOME", nullable = true)
    private String nome;

    @Column(name = "CATEGORIA", nullable = true)
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    @JsonBackReference
    private Post post;
}
