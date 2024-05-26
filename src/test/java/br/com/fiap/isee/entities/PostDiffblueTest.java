package br.com.fiap.isee.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PostDiffblueTest {
    /**
     * Method under test: {@link Post#toString()}
     */
    @Test
    void testToString() {
        // Arrange, Act and Assert
        assertEquals("Post{id=null, titulo='null', conteudo='null', tags=[]}", (new Post()).toString());
    }
}
