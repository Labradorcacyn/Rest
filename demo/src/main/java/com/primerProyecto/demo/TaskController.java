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

    @PostMapping("/")
    public ResponseEntity<Task> create(@RequestBody Task task){
   // return repository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(task)) ;
    }
}
