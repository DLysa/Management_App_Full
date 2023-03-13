package pl.management.app.management_app.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.management.app.management_app.api.model.Status;
import pl.management.app.management_app.api.repository.StatusRepository;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api")
public class StatusController {

    @Autowired
    private StatusRepository repository;

    @PostMapping("/addStatus")
    public String addStatus(@RequestBody Status status) {
        repository.save(status);
        return "Added status with id: " + status.getId();
    }
    @GetMapping("/showAllStatus")
    public List<Status> getAllStatus(){
        return repository.findAll();
    }

    @GetMapping("/showStatus/{id}")
    public Optional<Status> getStatus(@PathVariable int id){
        return repository.findById(id);
    }

    @DeleteMapping("/deleteStatus/{id}")
    public String deleteStatus(@PathVariable int id){
        repository.deleteById(id);
        return "Task with id: " + id +" deleted";
    }
}
