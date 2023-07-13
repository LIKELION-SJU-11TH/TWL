package board.example.demo.service;

import board.example.demo.entity.Articles;
import board.example.demo.entity.Image;
import board.example.demo.model.PostDAO;
import board.example.demo.model.PostDTO;
import board.example.demo.util.ImageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    private final PostDAO postDAO;
    private final ImageUtil imageUtil;
    public void createPost(PostDTO postDto) {
        this.postDAO.createPost(postDto);
    }

    public List<Articles> searchAllPost()
    {
        return this.postDAO.readAllPost();
    }

    public List<Articles> searchALLPostById(Long member_id) {
        return this.postDAO.readPost(member_id);
    }

    public List<Articles> searchArticlesByTitle(String keyword) {
        return this.postDAO.findByTitleContaining(keyword);
    }
    public List<Articles> searchArticlesByContent(String keyword) {
        return this.postDAO.findByContentContaining(keyword);
    }

    public void deletePost(Long id) {
        this.postDAO.deletePost(id);
    }

    public void updateArticle(Long article_id, Articles updatedArticle)
    {
        PostDTO postDTO = new PostDTO();
        postDTO.setTitle(updatedArticle.getTitle());
        postDTO.setContent(updatedArticle.getContent());
        this.postDAO.updateArticle(article_id, postDTO);
    }
    //이미지

    public void createPostWithImage(PostDTO postDto, List<MultipartFile> multipartFiles) throws Exception {

    }
}
