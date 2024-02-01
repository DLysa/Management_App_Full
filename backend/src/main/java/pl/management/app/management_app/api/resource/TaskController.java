package pl.management.app.management_app.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.management.app.management_app.api.model.Task;
import pl.management.app.management_app.api.repository.TaskRepository;


import java.util.List;
import java.util.Optional;

import static pl.management.app.management_app.api.model.Task.SEQUENCE_NAME;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private SequenceContoller sequenceContoller;


    @PostMapping("/addTask")
    public String addTask(@RequestBody Task task) {
        task.setId(sequenceContoller.getSequenceNumber(SEQUENCE_NAME));
        repository.save(task);
        return "Added task with id: " + task.getId();
    }

    @PostMapping("/updateTask")
    public String updateTask(@RequestBody Task task) {
        repository.save(task);
        return "Added task with id: " + task.getId();
    }
    @GetMapping("/showAllTasks")
    public List<Task> getTasks(){
        return repository.findAll();
    }
    @GetMapping("/showTask/{id}")
    public Optional<Task> getTask(@PathVariable int id){
        return repository.findById(id);
    }


    @PostMapping("/archiveTask")
    public String archiveTask(@RequestBody Task task) {
        task.setArchive(Boolean.TRUE);
        repository.save(task);
        return "Archived task with id: " + task.getId();
    }

    @PostMapping("/unArchiveTask")
    public String unArchiveTask(@RequestBody Task task) {
        task.setArchive(Boolean.FALSE);
        repository.save(task);
        return "Archived task with id: " + task.getId();
    }

    @DeleteMapping("/deleteTask/{id}")
    public String deleteStatus(@PathVariable int id){
        repository.deleteById(id);
        return "Task with id: " + id +" deleted";
    }
}
