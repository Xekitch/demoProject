package com.yefanov.demo.services;

import com.yefanov.demo.entities.Team;

import java.util.List;

public interface TeamService {

    Team getTeamById(int id);

    List<Team> getAllTeams();
}
