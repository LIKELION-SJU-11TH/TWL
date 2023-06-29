package board.example.demo.model;

import board.example.demo.entity.Articles;
import board.example.demo.entity.Member;
import board.example.demo.repository.BoardRepository;
import board.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO{

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public void createPost(PostDTO postDto) {
        Member member = memberRepository.findById(postDto.getMember_id()).orElse(null);

        Articles new_article = new Articles();
        new_article.setTitle(postDto.getTitle());
        new_article.setContent(postDto.getContent());

        if (member != null) {
            new_article.setMember(member);
            member.getArticles().add(new_article);
            this.boardRepository.save(new_article);
            this.memberRepository.save(member);
        }

        else {
            Member new_member = new Member();
            new_member.setMemberId(postDto.getMember_id());
            new_member.getArticles().add(new_article);
            Member savedMember = this.memberRepository.save(new_member);
            new_article.setMember(savedMember);
            this.boardRepository.save(new_article);

        }
    }

    public List<Articles> readAllPost()
    {
        return this.boardRepository.findAll();
    }


    public List<Articles> readPost(Long member_id)
    {
        Member member = memberRepository.findById(member_id).orElse(null);
        if(member == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return member.getArticles();
    }

    public List<Articles> findByTitleContaining(String keyword)
    {
        return this.boardRepository.findByTitleContaining(keyword);
    }
    public List<Articles>findByContentContaining(String keyword)
    {
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
}
