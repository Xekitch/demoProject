package com.yefanov.demo.services;

import com.yefanov.demo.entities.Footballer;
import com.yefanov.demo.repositories.FootballerRepository;
import com.yefanov.demo.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballerServiceImpl implements FootballerService {

    @Autowired
    private FootballerRepository footRepo;

    @Autowired
    private TeamRepository teamRepo;

    @Override
    public Footballer getFootballerById(int id) {
        return footRepo.findOne(id);
    }

    @Override
    public void addFootballer(Footballer footballer) {
        footRepo.save(footballer);
    }

    @Override
    public List<Footballer> getAllFootballers() {
        return footRepo.findAll();
    }
}
