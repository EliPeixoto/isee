package br.com.fiap.isee.dto;

import java.time.LocalDateTime;

public record UsersDTO(

        Long id,
        String nome,
        String email,
        String senha,
        LocalDateTime criacao,
        LocalDateTime atualizacao

) {
}
