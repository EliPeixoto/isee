package br.com.fiap.isee.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import br.com.fiap.isee.entities.Usuario;
import br.com.fiap.isee.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UsuarioController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class UsuarioControllerDiffblueTest {
    @MockBean
    private HttpServletResponse httpServletResponse;

    @Autowired
    private UsuarioController usuarioController;

    @MockBean
    private UsuarioService usuarioService;

    /**
     * Method under test: {@link UsuarioController#findAll()}
     */
    @Test
    void testFindAll() throws Exception {
        // Arrange
        when(usuarioService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/usuarios");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link UsuarioController#findById(UUID)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindById() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        Usuario usuario = new Usuario();
        usuario.setEmail("jane.doe@example.org");
        usuario.setId(UUID.randomUUID());
        usuario.setNome("Nome");
        usuario.setSenha("Senha");
        when(usuarioService.findById(Mockito.<UUID>any())).thenReturn(usuario);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/usuarios/{id}", UUID.randomUUID());

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":\"7ced358d-7295-4d60-8bbf-e336248e451e\",\"nome\":\"Nome\",\"email\":\"jane.doe@example.org\",\"senha"
                                        + "\":\"Senha\"}"));
    }

    /**
     * Method under test: {@link UsuarioController#save(Usuario)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSave() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        Usuario usuario = new Usuario();
        usuario.setEmail("jane.doe@example.org");
        usuario.setId(UUID.randomUUID());
        usuario.setNome("Nome");
        usuario.setSenha("Senha");
        when(usuarioService.save(Mockito.<Usuario>any())).thenReturn(usuario);
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/usuarios")
                .contentType(MediaType.APPLICATION_JSON);

        Usuario usuario2 = new Usuario();
        usuario2.setEmail("jane.doe@example.org");
        usuario2.setId(UUID.randomUUID());
        usuario2.setNome("Nome");
        usuario2.setSenha("Senha");
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content((new ObjectMapper()).writeValueAsString(usuario2));

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":\"8e84523e-5cc0-4260-b00d-4a9187617cb2\",\"nome\":\"Nome\",\"email\":\"jane.doe@example.org\",\"senha"
                                        + "\":\"Senha\"}"));
    }

    /**
     * Method under test: {@link UsuarioController#update(UUID, Usuario)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        Usuario usuario = new Usuario();
        usuario.setEmail("jane.doe@example.org");
        usuario.setId(UUID.randomUUID());
        usuario.setNome("Nome");
        usuario.setSenha("Senha");
        when(usuarioService.update(Mockito.<UUID>any(), Mockito.<Usuario>any())).thenReturn(usuario);
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.put("/usuarios/{id}", UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON);

        Usuario usuario2 = new Usuario();
        usuario2.setEmail("jane.doe@example.org");
        usuario2.setId(UUID.randomUUID());
        usuario2.setNome("Nome");
        usuario2.setSenha("Senha");
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content((new ObjectMapper()).writeValueAsString(usuario2));

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":\"081be6e5-4a2c-4c8b-af61-49b401cdadf3\",\"nome\":\"Nome\",\"email\":\"jane.doe@example.org\",\"senha"
                                        + "\":\"Senha\"}"));
    }

    /**
     * Method under test: {@link UsuarioController#delete(UUID)}
     */
    @Test
    void testDelete() throws Exception {
        // Arrange
        doNothing().when(usuarioService).delete(Mockito.<UUID>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/usuarios/{id}", UUID.randomUUID());

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link UsuarioController#delete(UUID)}
     */
    @Test
    void testDelete2() throws Exception {
        // Arrange
        doNothing().when(usuarioService).delete(Mockito.<UUID>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/usuarios/{id}", UUID.randomUUID());
        requestBuilder.contentType("https://example.org/example");

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
