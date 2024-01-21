package pl.management.app.management_app.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.management.app.management_app.auth.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void deleteUserByUsername(String username) {
        userRepository.deleteByUsername(username);
    }


}
