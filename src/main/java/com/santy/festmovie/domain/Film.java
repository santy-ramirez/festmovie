package com.santy.festmovie.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;

    private LocalDate creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
   @ManyToMany(cascade = CascadeType.PERSIST)
   @JoinTable(name = "film_actor", joinColumns = @JoinColumn (name ="film_id"), inverseJoinColumns  = @JoinColumn(name= "actor_id"))
    private Set<Actor> actors = new HashSet<>();


    public Film(String name, String title, String description, LocalDate creationDate,Category category) {

        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.category = category;
    }

    public Film() {
    }
    public void addActor(Actor actor){
        actors.add(actor);

        actor.getFilms(this);
    }
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(id, film.id)  && Objects.equals(title, film.title) && Objects.equals(description, film.description) && Objects.equals(creationDate, film.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, creationDate);
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
