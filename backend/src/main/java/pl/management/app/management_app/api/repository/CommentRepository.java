package pl.management.app.management_app.api.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import pl.management.app.management_app.api.model.Comment;

public interface CommentRepository extends MongoRepository <Comment, Integer> {
}
