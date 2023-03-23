package pl.management.app.management_app.auth.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.management.app.management_app.auth.model.User;
import pl.management.app.management_app.auth.repository.UserRepository;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = "*")
public class UserServiceApplication {
    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public String login(){
        return "auth success";
    }
    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return Stream.of(new User(1,"dominik","123","ADMIN","Dominik", "Lysak","dominik@gmail.com"))
                     /*   new User(101,"Piotr","Lysak","piotr@gmail.com"))*/.collect(Collectors.toList());
    }

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


