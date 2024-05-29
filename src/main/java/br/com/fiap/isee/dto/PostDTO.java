package br.com.fiap.isee.dto;

import br.com.fiap.isee.entities.Tags;

import java.util.List;

public record PostDTO(

        String id,
        String titulo,
        String conteudo,
        List<Tags> tags

) {
}
