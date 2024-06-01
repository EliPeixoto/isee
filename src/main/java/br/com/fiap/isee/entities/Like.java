package br.com.fiap.isee.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name="tb_likes")
@NoArgsConstructor
@AllArgsConstructor
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private Users user;


    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;


    private LocalDateTime dataCurtida;

    public Like(Users user, Post post) {
        this.user = user;
        this.post = post;
        this.dataCurtida = LocalDateTime.now();
    }

}


