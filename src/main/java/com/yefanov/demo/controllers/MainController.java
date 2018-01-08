package com.yefanov.demo.controllers;

import com.yefanov.demo.entities.Footballer;
import com.yefanov.demo.entities.Team;
import com.yefanov.demo.repositories.FootballerRepository;
import com.yefanov.demo.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;

@Controller
public class MainController {

    @Autowired
    private FootballerRepository footRepo;

    @Autowired
    private TeamRepository teamRepo;

    @RequestMapping("/")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/footballers")
    public String footballers(Model model) {
        model.addAttribute("footballers", footRepo.findAll());
        return "footballers";
    }

    @RequestMapping(value = "/footballer/{id}", method = RequestMethod.GET)
    public String footballer(@PathVariable("id") int id, Model model) {
        model.addAttribute("footballer", footRepo.getOne(id));
        return "footballer";
    }

    @RequestMapping(value = "/editFootballer/{id}", method = RequestMethod.GET)
    public String editFootballer(@PathVariable("id") int id, Model model) {
        model.addAttribute("editable", footRepo.getOne(id));
        model.addAttribute("teams", teamRepo.findAll());
        return "editFootballer";
    }

    @RequestMapping(value = "/editFootballer", method = RequestMethod.POST)
    public String editFootballer(@ModelAttribute Footballer foot, Model model) {
        Footballer oldFoot = footRepo.getOne(foot.getId());
        oldFoot.setFirstName(foot.getFirstName());
        oldFoot.setLastName(foot.getLastName());
        oldFoot.setDateOfBirth(foot.getDateOfBirth());
        oldFoot.setTeam(teamRepo.getOne(foot.getTeam().getId()));
        model.addAttribute("footballers", footRepo.findAll());
        return "footballers";
    }

    @RequestMapping(value = "/deleteFootballer/{id}", method = RequestMethod.GET)
    public String deleteFootballer(@PathVariable("id") int id, Model model) {
        Footballer foot = footRepo.getOne(id);
        footRepo.delete(foot);
        model.addAttribute("footballers", footRepo.findAll());
        return "footballers";
    }

    @RequestMapping(value = "/addFootballer", method = RequestMethod.GET)
    public String addFootballer(Model model) {
        model.addAttribute("newFoot", new Footballer());
        model.addAttribute("teams", teamRepo.findAll());
        return "addFootballer";
    }

    @RequestMapping(value = "/addFootballer", method = RequestMethod.POST)
    public String addFootballer(@ModelAttribute Footballer foot, Model model) {
        foot.setTeam(teamRepo.findOne(foot.getTeam().getId()));
        footRepo.save(foot);
        model.addAttribute("footballers", footRepo.findAll());
        return "footballers";
    }
}
