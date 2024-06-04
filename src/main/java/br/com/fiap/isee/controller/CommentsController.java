package br.com.fiap.isee.controller;

import br.com.fiap.isee.entities.Comments;
import br.com.fiap.isee.service.CommentsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @Operation(summary = "cria comentario na postagem", tags = "Comments")
    @PostMapping("/{postId}")
    public void commentPost(@RequestParam Long userId, @PathVariable Long postId, @RequestParam String comentario){
        commentsService.commentsPost(userId, postId, comentario);
    }

    @Operation(summary = "Exclui comentario na postagem", tags = "Comments")
    @DeleteMapping("/{postId}")
    public void descommentsPost(@RequestParam Long userId, Long postId){
        commentsService.descommentsPost(userId, postId);
    }

    @Operation(summary = "Retorna quantidade de comentarios em cada postagem", tags = "Comments")
    @GetMapping("/contar-comments/{postId}")
    public Long countComments(@PathVariable Long postId) {
        return commentsService.countComments(postId);
    }

    @Operation(summary = "Retorna comentários de uma postagem", tags = "Comments")
    @GetMapping("/comentarios/{postId}")
    public List<Comments> getCommentsByPostId(@PathVariable Long postId) {
        return commentsService.getCommentsByPostId(postId);
    }
}
