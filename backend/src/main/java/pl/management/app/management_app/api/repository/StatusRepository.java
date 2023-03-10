package pl.management.app.management_app.api.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import pl.management.app.management_app.api.model.Status;

public interface StatusRepository extends MongoRepository <Status, Integer> {
        }