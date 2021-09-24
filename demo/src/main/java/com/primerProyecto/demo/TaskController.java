package com.primerProyecto.demo;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // equivale a @Controller + @ResponseBody
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepository repository;

    @GetMapping("/")
    public List<Task> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Task findOne(@PathVariable("id") Long id){
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public ResponseEntity<Task> create(@RequestBody Task task){
   // return repository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(task)) ;
    }

    @PutMapping ("/{id}")
    public Task edit(@RequestBody Task task, @PathVariable Long id){
    repository.findById(id).orElse(task).getText();
    repository.findById(id).orElse(task).getTitle();
    return repository.save(repository.findById(id).orElse(task));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build(); // Es más legible

    }
}
