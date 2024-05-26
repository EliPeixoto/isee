package br.com.fiap.isee.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class TagsDiffblueTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Tags#Tags()}
     *   <li>{@link Tags#setCategoria(String)}
     *   <li>{@link Tags#setId(UUID)}
     *   <li>{@link Tags#setNome(String)}
     *   <li>{@link Tags#setPost(Post)}
     *   <li>{@link Tags#getCategoria()}
     *   <li>{@link Tags#getId()}
     *   <li>{@link Tags#getNome()}
     *   <li>{@link Tags#getPost()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        Tags actualTags = new Tags();
        actualTags.setCategoria("Categoria");
        UUID id = UUID.randomUUID();
        actualTags.setId(id);
        actualTags.setNome("Nome");
        Post post = new Post();
        post.setConteudo("Conteudo");
        post.setId(UUID.randomUUID());
        post.setTags(new ArrayList<>());
        post.setTitulo("Titulo");
        actualTags.setPost(post);
        String actualCategoria = actualTags.getCategoria();
        UUID actualId = actualTags.getId();
        String actualNome = actualTags.getNome();

        // Assert that nothing has changed
        assertEquals("Categoria", actualCategoria);
        assertEquals("Nome", actualNome);
        assertSame(post, actualTags.getPost());
        assertSame(id, actualId);
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Tags#Tags(UUID, String, String, Post)}
     *   <li>{@link Tags#setCategoria(String)}
     *   <li>{@link Tags#setId(UUID)}
     *   <li>{@link Tags#setNome(String)}
     *   <li>{@link Tags#setPost(Post)}
     *   <li>{@link Tags#getCategoria()}
     *   <li>{@link Tags#getId()}
     *   <li>{@link Tags#getNome()}
     *   <li>{@link Tags#getPost()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange
        UUID id = UUID.randomUUID();

        Post post = new Post();
        post.setConteudo("Conteudo");
        post.setId(UUID.randomUUID());
        post.setTags(new ArrayList<>());
        post.setTitulo("Titulo");

        // Act
        Tags actualTags = new Tags(id, "Nome", "Categoria", post);
        actualTags.setCategoria("Categoria");
        UUID id2 = UUID.randomUUID();
        actualTags.setId(id2);
        actualTags.setNome("Nome");
        Post post2 = new Post();
        post2.setConteudo("Conteudo");
        post2.setId(UUID.randomUUID());
        post2.setTags(new ArrayList<>());
        post2.setTitulo("Titulo");
        actualTags.setPost(post2);
        String actualCategoria = actualTags.getCategoria();
        UUID actualId = actualTags.getId();
        String actualNome = actualTags.getNome();

        // Assert that nothing has changed
        assertEquals("Categoria", actualCategoria);
        assertEquals("Nome", actualNome);
        assertSame(post2, actualTags.getPost());
        assertSame(id2, actualId);
    }
}
