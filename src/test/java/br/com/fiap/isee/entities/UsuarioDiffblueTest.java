package br.com.fiap.isee.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.UUID;

import org.junit.jupiter.api.Test;

class UsuarioDiffblueTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Usuario#Usuario()}
     *   <li>{@link Usuario#setEmail(String)}
     *   <li>{@link Usuario#setId(UUID)}
     *   <li>{@link Usuario#setNome(String)}
     *   <li>{@link Usuario#setSenha(String)}
     *   <li>{@link Usuario#getEmail()}
     *   <li>{@link Usuario#getId()}
     *   <li>{@link Usuario#getNome()}
     *   <li>{@link Usuario#getSenha()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        Usuario actualUsuario = new Usuario();
        actualUsuario.setEmail("jane.doe@example.org");
        UUID id = UUID.randomUUID();
        actualUsuario.setId(id);
        actualUsuario.setNome("Nome");
        actualUsuario.setSenha("Senha");
        String actualEmail = actualUsuario.getEmail();
        UUID actualId = actualUsuario.getId();
        String actualNome = actualUsuario.getNome();

        // Assert that nothing has changed
        assertEquals("Nome", actualNome);
        assertEquals("Senha", actualUsuario.getSenha());
        assertEquals("jane.doe@example.org", actualEmail);
        assertSame(id, actualId);
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Usuario#Usuario(UUID, String, String, String)}
     *   <li>{@link Usuario#setEmail(String)}
     *   <li>{@link Usuario#setId(UUID)}
     *   <li>{@link Usuario#setNome(String)}
     *   <li>{@link Usuario#setSenha(String)}
     *   <li>{@link Usuario#getEmail()}
     *   <li>{@link Usuario#getId()}
     *   <li>{@link Usuario#getNome()}
     *   <li>{@link Usuario#getSenha()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        Usuario actualUsuario = new Usuario(UUID.randomUUID(), "Nome", "jane.doe@example.org", "Senha");
        actualUsuario.setEmail("jane.doe@example.org");
        UUID id = UUID.randomUUID();
        actualUsuario.setId(id);
        actualUsuario.setNome("Nome");
        actualUsuario.setSenha("Senha");
        String actualEmail = actualUsuario.getEmail();
        UUID actualId = actualUsuario.getId();
        String actualNome = actualUsuario.getNome();

        // Assert that nothing has changed
        assertEquals("Nome", actualNome);
        assertEquals("Senha", actualUsuario.getSenha());
        assertEquals("jane.doe@example.org", actualEmail);
        assertSame(id, actualId);
    }
}
