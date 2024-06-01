package br.com.fiap.isee.controller;

import br.com.fiap.isee.service.LikeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @Operation(summary = "Cria curtida na postagem", tags = "Likes")
    @PostMapping("/{postId}")
    public void likePost(@RequestParam Long userId, @PathVariable Long postId) {
        likeService.likePost(userId, postId);
    }

    @Operation(summary = "Exclui curtida na postagem", tags = "Likes")
    @DeleteMapping("/{postId}")
    public void deslikePost(@RequestParam Long userId, @PathVariable Long postId) {
        likeService.deslikePost(userId, postId);
    }

    @Operation(summary = "Retorna quantidade de curtidas em cada postagem", tags = "Likes")
    @GetMapping("/contar-like/{postId}")
    public Long countLike(@PathVariable Long postId) {
        return likeService.countLike(postId);
    }
}
