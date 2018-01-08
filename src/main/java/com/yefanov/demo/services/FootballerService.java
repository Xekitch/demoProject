package com.yefanov.demo.services;

import com.yefanov.demo.entities.Footballer;

import java.util.List;

public interface FootballerService {

    Footballer getFootballerById(int id);

    void addFootballer(Footballer footballer);

    List<Footballer> getAllFootballers();
}
