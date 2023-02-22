package pl.management.app.management_app.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.management.app.management_app.api.model.Task;
import pl.management.app.management_app.api.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @PostMapping("/addTask")
    public String addTask(@RequestBody Task task) {
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

    @DeleteMapping("/deleteTask/{id}")
    public String deleteBook(@PathVariable int id){
        repository.deleteById(id);
        return "Task with id: " + id +" deleted";
    }
}
