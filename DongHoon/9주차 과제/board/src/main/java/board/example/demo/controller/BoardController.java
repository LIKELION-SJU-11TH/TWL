package board.example.demo.controller;

import board.example.demo.entity.Articles;
import board.example.demo.model.PostDTO;
import board.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
@RestController
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @PostMapping("post")
    public void createPost(@RequestBody PostDTO postDto)
    {
        this.boardService.createPost(postDto);
    }

    @GetMapping("all")
    public List<Articles> readAllPost()
    {
        return this.boardService.searchAllPost();
    }

    @GetMapping("{member_id}")
    public List<Articles> readPost(@PathVariable("member_id") Long member_id){
        return this.boardService.searchALLPostById(member_id);
    }

    @GetMapping("title/{keyword}")
    public List<Articles> searchArticlesByTitle(@PathVariable("keyword") String keyword) {
        return this.boardService.searchArticlesByTitle(keyword);
    }

    @GetMapping("content/{keyword}")
    public List<Articles> searchArticlesByContent(@PathVariable("keyword") String keyword) {
        return this.boardService.searchArticlesByContent(keyword);
    }

    @PutMapping("{id}")
    public void updateArticle(@PathVariable Long id, @RequestBody Articles updatedArticle) {
        this.boardService.updateArticle(id, updatedArticle);
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id") Long id)
    {
        this.boardService.deletePost(id);
    }


    //이미지 업로드

    @PostMapping(value = "Image",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public void createPostWithImage(@RequestPart PostDTO postDTO,
                                                 @RequestPart("files") List<MultipartFile> files) throws IOException {
        this.boardService.createPostWithImage(postDTO, files);
    }
}
