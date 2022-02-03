package repositories;

import model.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagsRepository extends JpaRepository<Hashtag, String> {

}
