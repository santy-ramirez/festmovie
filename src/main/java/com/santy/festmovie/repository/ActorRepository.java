package com.santy.festmovie.repository;

import com.santy.festmovie.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository  extends JpaRepository<Actor,Long> {
}
