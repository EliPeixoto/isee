package br.com.fiap.isee.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @UpdateTimestamp
    @Column(name= "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name= "updated_at")
    private Date updatedAt;

    @ManyToOne
    private Post post;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Users user;

}


