package br.com.fiap.isee.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_tags")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tags {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    @JsonBackReference
    private Post post;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Users users;
}
