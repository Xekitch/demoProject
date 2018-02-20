package com.yefanov.demo.repositories;

import com.yefanov.demo.entities.Footballer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("footRepo")
public interface FootballerRepository extends JpaRepository<Footballer, Integer> {

}
