package pl.management.app.management_app.auth.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.management.app.management_app.api.resource.SequenceContoller;
import pl.management.app.management_app.auth.model.User;
import pl.management.app.management_app.auth.repository.UserRepository;
import pl.management.app.management_app.auth.service.UserService;

import java.util.List;

//import static pl.management.app.management_app.auth.model.User.SEQUENCE_NAME;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/secure/auth")
public class UserServiceApplication {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private SequenceContoller sequenceController;

/*
    @GetMapping("/")
    public String login(){
        return "auth success";
    }
*/
    //@PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/addUser")
    public String addUserByAdmin(@RequestBody User user) {
  //      user.setId(sequenceController.getSequenceNumber(SEQUENCE_NAME));
        String pwd = user.getPassword();
        String encryptPwd = passwordEncoder.encode(pwd);
        user.setPassword(encryptPwd);
        userRepository.save(user);
        return "user added successfully...";
    }





    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin/all")
    public String securedHello() {
        return "Secured Hello";
    }

//    @GetMapping("/getUsers")
//    public List<User> getUsers(){
//        return Stream.of(new User(1,"dominik","123","ADMIN","Dominik", "Lysak","dominik@gmail.com"))
//                     /*   new User(101,"Piotr","Lysak","piotr@gmail.com"))*/.collect(Collectors.toList());
//    }


    @GetMapping("/showAllUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @DeleteMapping("/deleteUser/{username}")
    public String deleteUser(@PathVariable String username){
        userService.deleteUserByUsername(username);
        return "User with username " + username +" deleted";
    }
}


