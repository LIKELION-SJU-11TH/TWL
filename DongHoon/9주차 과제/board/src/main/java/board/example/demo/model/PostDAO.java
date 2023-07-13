package board.example.demo.model;

import board.example.demo.entity.Articles;
import board.example.demo.entity.Image;
import board.example.demo.entity.Member;
import board.example.demo.repository.BoardRepository;
import board.example.demo.repository.ImageRepository;
import board.example.demo.repository.MemberRepository;
import board.example.demo.util.ImageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PostDAO{

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final ImageUtil imageUtil;
    private final ImageRepository imageRepository;

    public Articles createPost(PostDTO postDto) {
        Member member = memberRepository.findById(postDto.getMember_id()).orElse(null);

        Articles new_article = new Articles();
        new_article.setTitle(postDto.getTitle());
        new_article.setContent(postDto.getContent());

        if (member != null) {
            new_article.setMember(member);
            new_article.setCreatedAt(Instant.now());
            new_article.setUpdatedAt(Instant.now());
            member.getArticles().add(new_article);
            this.boardRepository.save(new_article);
            this.memberRepository.save(member);
        }

        return new_article;
    }

    public List<Articles> readAllPost() {
        return this.boardRepository.findAll();
    }

    public List<Articles> readPost(Long member_id) {
        Member member = memberRepository.findById(member_id).orElse(null);
        if(member == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return member.getArticles();
    }

    public List<Articles> findByTitleContaining(String keyword) {
        return this.boardRepository.findByTitleContaining(keyword);
    }

    public List<Articles>findByContentContaining(String keyword) {
        return this.boardRepository.findByContentContaining(keyword);
    }

    public void deletePost(Long article_id)
    {
        Optional<Articles> targetEntity = this.boardRepository.findById(article_id);
        if(targetEntity.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        this.boardRepository.delete(targetEntity.get());
    }

    public void updateArticle(Long article_id, PostDTO updatedArticle) {
        Articles existingArticle = this.boardRepository.findById(article_id).orElse(null);
        if (existingArticle == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        existingArticle.setTitle(updatedArticle.getTitle());
        existingArticle.setContent(updatedArticle.getContent());
        existingArticle.setUpdatedAt(Instant.from(LocalDateTime.now()));
        this.boardRepository.save(existingArticle);
    }

    @Transactional
    public void createPostWithImage(PostDTO postDto, List<MultipartFile> multipartFiles) throws Exception {
        Articles savedArticle = createPost(postDto);
        List<String> imgNameList;
        imgNameList = imageUtil.uploadImage(multipartFiles);

        try {
            for (String imgName : imgNameList) {
                Image imgFile = Image.builder()
                        .url(imgName)
                        .article(savedArticle).build();
                imageRepository.save(imgFile);
            }
        } catch (Exception e) {
            throw new BaseException(DATABASE_INSERT_ERROR);
        }

        try {
            for (String imgName : imgNameList) {
                Image imgFile = Image.builder()
                        .url(imgName)
                        .article(savedArticle).build();
                imageRepository.save(imgFile);
            }
        } catch (Exception e) {
            throw new BaseException(DATABASE_INSERT_ERROR);
        }
    }
}
