package com.yefanov.demo.services;

import com.yefanov.demo.entities.Team;
import com.yefanov.demo.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepo;

    @Override
    public Team getTeamById(int id) {
        return teamRepo.findOne(id);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepo.findAll();
    }
}
