package pl.management.app.management_app.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.management.app.management_app.api.model.Comment;
import pl.management.app.management_app.api.repository.CommentRepository;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api")
public class CommentController {

    @Autowired
    private CommentRepository repository;

    @PostMapping("/addComment")
    public String addComment(@RequestBody Comment comment) {
        repository.save(comment);
        return "Added comment with id: " + comment.getId();
    }
/*
    @GetMapping("/showComment/{taskId}")
    public List<Comment> getComment(@PathVariable int taskId) {
        return repository.findAll().stream().filter(taskId=this.);
    }*/

    @GetMapping("/showAllComments")
    public List<Comment> getAllComments(){
        return repository.findAll();
    }


}
