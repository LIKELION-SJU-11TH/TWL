package board.example.demo.repository;
import board.example.demo.entity.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface BoardRepository  extends JpaRepository<Articles, Long> {
    List<Articles> findByTitleContaining(String keyword);
    List<Articles> findByContentContaining(String keyword);
}
