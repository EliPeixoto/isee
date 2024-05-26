package br.com.fiap.isee.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.fiap.isee.entities.Post;
import br.com.fiap.isee.entities.Tags;
import br.com.fiap.isee.repository.PostRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PostService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class PostServiceDiffblueTest {
    @MockBean
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    /**
     * Method under test: {@link PostService#findAll()}
     */
    @Test
    void testFindAll() {
        // Arrange
        ArrayList<Post> postList = new ArrayList<>();
        when(postRepository.findAll()).thenReturn(postList);

        // Act
        Collection<Post> actualFindAllResult = postService.findAll();

        // Assert
        verify(postRepository).findAll();
        assertTrue(actualFindAllResult.isEmpty());
        assertSame(postList, actualFindAllResult);
    }

    /**
     * Method under test: {@link PostService#findById(UUID)}
     */
    @Test
    void testFindById() {
        // Arrange
        Post post = new Post();
        post.setConteudo("Conteudo");
        post.setId(UUID.randomUUID());
        post.setTags(new ArrayList<>());
        post.setTitulo("Titulo");
        Optional<Post> ofResult = Optional.of(post);
        when(postRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);

        // Act
        Optional<Post> actualFindByIdResult = postService.findById(UUID.randomUUID());

        // Assert
        verify(postRepository).findById(isA(UUID.class));
        assertSame(ofResult, actualFindByIdResult);
    }

    /**
     * Method under test: {@link PostService#save(Post)}
     */
    @Test
    void testSave() {
        // Arrange
        Post post = new Post();
        post.setConteudo("Conteudo");
        post.setId(UUID.randomUUID());
        post.setTags(new ArrayList<>());
        post.setTitulo("Titulo");
        when(postRepository.save(Mockito.<Post>any())).thenReturn(post);

        Post post2 = new Post();
        post2.setConteudo("Conteudo");
        post2.setId(UUID.randomUUID());
        post2.setTags(new ArrayList<>());
        post2.setTitulo("Titulo");

        // Act
        Post actualSaveResult = postService.save(post2);

        // Assert
        verify(postRepository).save(isA(Post.class));
        assertSame(post, actualSaveResult);
    }

    /**
     * Method under test: {@link PostService#save(Post)}
     */
    @Test
    void testSave2() {
        // Arrange
        Post post = new Post();
        post.setConteudo("Conteudo");
        post.setId(UUID.randomUUID());
        post.setTags(new ArrayList<>());
        post.setTitulo("Titulo");
        when(postRepository.save(Mockito.<Post>any())).thenReturn(post);

        Post post2 = new Post();
        post2.setConteudo("Conteudo");
        post2.setId(UUID.randomUUID());
        post2.setTags(new ArrayList<>());
        post2.setTitulo("Titulo");

        Tags tags = new Tags();
        tags.setCategoria("Categoria");
        tags.setId(UUID.randomUUID());
        tags.setNome("Nome");
        tags.setPost(post2);

        ArrayList<Tags> tags2 = new ArrayList<>();
        tags2.add(tags);

        Post post3 = new Post();
        post3.setConteudo("Conteudo");
        post3.setId(UUID.randomUUID());
        post3.setTags(tags2);
        post3.setTitulo("Titulo");

        // Act
        Post actualSaveResult = postService.save(post3);

        // Assert
        verify(postRepository).save(isA(Post.class));
        assertSame(post3, post3.getTags().get(0).getPost());
        assertSame(post, actualSaveResult);
    }

    /**
     * Method under test: {@link PostService#save(Post)}
     */
    @Test
    void testSave3() {
        // Arrange
        Post post = new Post();
        post.setConteudo("Conteudo");
        post.setId(UUID.randomUUID());
        post.setTags(new ArrayList<>());
        post.setTitulo("Titulo");
        when(postRepository.save(Mockito.<Post>any())).thenReturn(post);

        Post post2 = new Post();
        post2.setConteudo("Conteudo");
        post2.setId(UUID.randomUUID());
        post2.setTags(new ArrayList<>());
        post2.setTitulo("Titulo");

        Tags tags = new Tags();
        tags.setCategoria("Categoria");
        tags.setId(UUID.randomUUID());
        tags.setNome("Nome");
        tags.setPost(post2);

        Post post3 = new Post();
        post3.setConteudo("42");
        post3.setId(UUID.randomUUID());
        post3.setTags(new ArrayList<>());
        post3.setTitulo("42");

        Tags tags2 = new Tags();
        tags2.setCategoria("42");
        tags2.setId(UUID.randomUUID());
        tags2.setNome("42");
        tags2.setPost(post3);

        ArrayList<Tags> tags3 = new ArrayList<>();
        tags3.add(tags2);
        tags3.add(tags);

        Post post4 = new Post();
        post4.setConteudo("Conteudo");
        post4.setId(UUID.randomUUID());
        post4.setTags(tags3);
        post4.setTitulo("Titulo");

        // Act
        Post actualSaveResult = postService.save(post4);

        // Assert
        verify(postRepository).save(isA(Post.class));
        List<Tags> tags4 = post4.getTags();
        assertSame(post4, tags4.get(0).getPost());
        assertSame(post4, tags4.get(1).getPost());
        assertSame(post, actualSaveResult);
    }

    /**
     * Method under test: {@link PostService#update(UUID, Post)}
     */
    @Test
    void testUpdate() {
        // Arrange
        Post post = new Post();
        post.setConteudo("Conteudo");
        post.setId(UUID.randomUUID());
        post.setTags(new ArrayList<>());
        post.setTitulo("Titulo");

        Post post2 = new Post();
        post2.setConteudo("Conteudo");
        post2.setId(UUID.randomUUID());
        post2.setTags(new ArrayList<>());
        post2.setTitulo("Titulo");
        when(postRepository.save(Mockito.<Post>any())).thenReturn(post2);
        when(postRepository.getOne(Mockito.<UUID>any())).thenReturn(post);
        UUID id = UUID.randomUUID();

        Post post3 = new Post();
        post3.setConteudo("Conteudo");
        post3.setId(UUID.randomUUID());
        post3.setTags(new ArrayList<>());
        post3.setTitulo("Titulo");

        // Act
        Post actualUpdateResult = postService.update(id, post3);

        // Assert
        verify(postRepository).getOne(isA(UUID.class));
        verify(postRepository).save(isA(Post.class));
        assertSame(post2, actualUpdateResult);
    }

    /**
     * Method under test: {@link PostService#delete(UUID)}
     */
    @Test
    void testDelete() {
        // Arrange
        doNothing().when(postRepository).deleteById(Mockito.<UUID>any());

        // Act
        postService.delete(UUID.randomUUID());

        // Assert that nothing has changed
        verify(postRepository).deleteById(isA(UUID.class));
        assertTrue(postService.findAll().isEmpty());
    }
}
