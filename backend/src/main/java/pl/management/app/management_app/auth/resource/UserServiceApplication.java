package pl.management.app.management_app.auth.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.management.app.management_app.auth.model.User;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class UserServiceApplication {


    @GetMapping("/")
    public String login(){
        return "auth success";
    }
    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return Stream.of(new User(108,"Dominik", "Lysak","dominik@gmail.com"),
                        new User(101,"Piotr","Lysak","piotr@gmail.com")).collect(Collectors.toList());
    }


}


