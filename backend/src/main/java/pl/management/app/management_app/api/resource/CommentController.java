package pl.management.app.management_app.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.management.app.management_app.api.model.Comment;
import pl.management.app.management_app.api.repository.CommentRepository;
import java.util.List;

import static pl.management.app.management_app.api.model.Comment.SEQUENCE_NAME;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api")
public class CommentController {

    @Autowired
    private CommentRepository repository;

    @Autowired
    private SequenceContoller sequenceContoller;

    @PostMapping("/addComment")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        try {
            comment.setId(sequenceContoller.getSequenceNumber(SEQUENCE_NAME));
            Comment savedComment = repository.save(comment);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedComment);
        } catch (Exception e) {
            // Log the exception and return an appropriate error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
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
