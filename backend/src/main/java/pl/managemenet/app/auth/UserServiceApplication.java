package pl.managemenet.app.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.managemenet.app.auth.User;


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


    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}


