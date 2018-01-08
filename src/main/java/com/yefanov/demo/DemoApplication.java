package com.yefanov.demo;

import com.yefanov.demo.entities.Footballer;
import com.yefanov.demo.entities.Team;
import com.yefanov.demo.repositories.FootballerRepository;
import com.yefanov.demo.repositories.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner setup(FootballerRepository footRepo, TeamRepository teamRepo) {
		return (args) -> {
			Team london = new Team("London FC");
			Team berlin = new Team("Berlin FC");
			Team madrid = new Team("Madrid FC");
			Footballer edenHazard = new Footballer("Eden", "Hazard", LocalDate.of(1985, 2, 12), london);
			Footballer luizSuarez = new Footballer("Luiz", "Suarez", LocalDate.of(1982, 4, 22), berlin);
			Footballer leoMessi = new Footballer("Leo", "Messi", LocalDate.of(1988, 3, 12), berlin);
			Footballer harryKane = new Footballer("Harry", "Kane", LocalDate.of(1990, 5, 4), london);
			Footballer tonyKroos = new Footballer("Tony", "Kroos", LocalDate.of(1990, 5, 25), madrid);
			teamRepo.save(london);
			teamRepo.save(berlin);
			teamRepo.save(madrid);
			footRepo.save(edenHazard);
			footRepo.save(luizSuarez);
			footRepo.save(leoMessi);
			footRepo.save(harryKane);
			footRepo.save(tonyKroos);
		};
	}
}
