package com.primerProyecto.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class InitData {
    private final TaskRepository repository;


    @PostConstruct
    public void init(){
        repository.saveAll(
                Arrays.asList(
                        new Task("holi", "Holi1"),
                        new Task("holi3", "Holi4")
                )
        );
    }
}
