package com.yefanov.demo.repositories;

import com.yefanov.demo.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("teamRepo")
public interface TeamRepository extends JpaRepository<Team, Integer> {

}
