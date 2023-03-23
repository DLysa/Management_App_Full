package pl.management.app.management_app.auth.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.management.app.management_app.auth.repository.UserRepository;
import pl.management.app.management_app.auth.model.User;

import java.util.List;

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
