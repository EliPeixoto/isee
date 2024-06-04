package br.com.fiap.isee.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_comentarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String comentario;
    @ManyToOne
    private Post post;
    @ManyToOne
    private Users user;
    private LocalDateTime dataComentario;

    public Comments(Users user, Post post, String comentario) {
        this.user = user;
        this.post = post;
        this.comentario = comentario;
        this.dataComentario = LocalDateTime.now();
    }
}
