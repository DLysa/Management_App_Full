package pl.management.app.management_app.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.management.app.management_app.api.model.User;
import pl.management.app.management_app.api.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
        repository.save(user);
        return "Added user with id: " + user.getId();
    }
    @GetMapping("/showAllUsers")
    public List<User> getAllUsers(){
        return repository.findAll();
    }


}
