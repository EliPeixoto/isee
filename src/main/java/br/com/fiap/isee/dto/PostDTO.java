package br.com.fiap.isee.dto;

import br.com.fiap.isee.entities.Users;

import java.util.List;

public record PostDTO(

        Long id,
        String titulo,
        String conteudo,
        Users user,
        List<String> tags

) {
}
