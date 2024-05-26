package br.com.fiap.isee.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import br.com.fiap.isee.entities.Post;
import br.com.fiap.isee.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Optional;
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

@ContextConfiguration(classes = {PostController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class PostControllerDiffblueTest {
    @Autowired
    private PostController postController;

    @MockBean
    private PostService postService;

    /**
     * Method under test: {@link PostController#findAll()}
     */
    @Test
    void testFindAll() throws Exception {
        // Arrange
        when(postService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/posts");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#findById(UUID)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindById() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        Post post = new Post();
        post.setConteudo("Conteudo");
        post.setId(UUID.randomUUID());
        post.setTags(new ArrayList<>());
        post.setTitulo("Titulo");
        Optional<Post> ofResult = Optional.of(post);
        when(postService.findById(Mockito.<UUID>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/posts/{id}", UUID.randomUUID());

        // Act and Assert
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":\"58cc5315-37c7-4189-812b-39481c2d8d98\",\"titulo\":\"Titulo\",\"conteudo\":\"Conteudo\",\"tags\":[]}"));
    }

    /**
     * Method under test: {@link PostController#save(Post)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSave() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        Post post = new Post();
        post.setConteudo("Conteudo");
        post.setId(UUID.randomUUID());
        post.setTags(new ArrayList<>());
        post.setTitulo("Titulo");
        when(postService.save(Mockito.<Post>any())).thenReturn(post);
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/posts")
                .contentType(MediaType.APPLICATION_JSON);

        Post post2 = new Post();
        post2.setConteudo("Conteudo");
        post2.setId(UUID.randomUUID());
        post2.setTags(new ArrayList<>());
        post2.setTitulo("Titulo");
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content((new ObjectMapper()).writeValueAsString(post2));

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(postController).build().perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":\"458aaa51-3e0f-4edd-bec8-3093b9202de4\",\"titulo\":\"Titulo\",\"conteudo\":\"Conteudo\",\"tags\":[]}"));
    }

    /**
     * Method under test: {@link PostController#update(UUID, Post)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        Post post = new Post();
        post.setConteudo("Conteudo");
        post.setId(UUID.randomUUID());
        post.setTags(new ArrayList<>());
        post.setTitulo("Titulo");
        when(postService.update(Mockito.<UUID>any(), Mockito.<Post>any())).thenReturn(post);
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.put("/posts/{id}", UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON);

        Post post2 = new Post();
        post2.setConteudo("Conteudo");
        post2.setId(UUID.randomUUID());
        post2.setTags(new ArrayList<>());
        post2.setTitulo("Titulo");
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content((new ObjectMapper()).writeValueAsString(post2));

        // Act and Assert
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":\"f3a181e8-60e8-4920-8713-302e5d841d87\",\"titulo\":\"Titulo\",\"conteudo\":\"Conteudo\",\"tags\":[]}"));
    }

    /**
     * Method under test: {@link PostController#delete(UUID)}
     */
    @Test
    void testDelete() throws Exception {
        // Arrange
        doNothing().when(postService).delete(Mockito.<UUID>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/posts/{id}", UUID.randomUUID());

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(postController).build().perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link PostController#delete(UUID)}
     */
    @Test
    void testDelete2() throws Exception {
        // Arrange
        doNothing().when(postService).delete(Mockito.<UUID>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/posts/{id}", UUID.randomUUID());
        requestBuilder.contentType("https://example.org/example");

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(postController).build().perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
