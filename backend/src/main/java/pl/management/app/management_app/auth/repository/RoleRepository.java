package pl.management.app.management_app.auth.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.management.app.management_app.auth.model.Role;
import pl.management.app.management_app.auth.model.User;

public interface RoleRepository extends MongoRepository<Role, Integer> {
}
