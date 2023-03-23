package pl.management.app.management_app.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.management.app.management_app.api.model.Comment;
import pl.management.app.management_app.api.repository.CommentRepository;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api")
public class CommentController {

    @Autowired
    private CommentRepository repository;

    @PostMapping("/addComment")
    public String addComment(@RequestBody Comment comment) {
        repository.save(comment);
        return "Added user with id: " + comment.getId();
    }
    @GetMapping("/showAllComments")
    public List<Comment> getAllComments(){
        return repository.findAll();
    }


}
