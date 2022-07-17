package com.santy.festmovie.controller;

import com.santy.festmovie.domain.Actor;
import com.santy.festmovie.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorController {

    private final ActorRepository actorRepository;
    @Autowired
    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @PostMapping("/actor")
    public Actor createActor(@RequestBody Actor actor){

        return actorRepository.save(actor);
    }
}
