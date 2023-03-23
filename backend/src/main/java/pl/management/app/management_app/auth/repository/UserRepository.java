package pl.management.app.management_app.auth.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import pl.management.app.management_app.auth.model.User;


public interface UserRepository extends MongoRepository <User, Integer> {
}
