package com.santy.festmovie.controller;

import com.santy.festmovie.domain.Actor;
import com.santy.festmovie.domain.Film;
import com.santy.festmovie.repository.ActorRepository;
import com.santy.festmovie.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class FilmController {

    private final FilmRepository filmRepository;
    private final ActorRepository actorRepository;
    @Autowired
    public FilmController(FilmRepository filmRepository, ActorRepository actorRepository) {
        this.filmRepository = filmRepository;
        this.actorRepository = actorRepository;
    }

    @PostMapping("/film")
    public Film createFilm(@RequestBody  Film film){
     return filmRepository.save(film);
    }

    @PostMapping("/film/{id}/actor")
    public Film addActorToMovie(@PathVariable Long id, @RequestBody List<Long> actorIds){
        Film film = filmRepository.findById(id).orElse(null);
      List<Actor> actors = actorIds.stream()
              .map(id1 -> actorRepository.findById(id))
              .filter(Optional::isPresent)
              .map(Optional::get)
              .collect(Collectors.toList());
    for (Actor actor : actors){
        film.addActor(actor);
    }
    filmRepository.save(film);
        return film;
    }
}
