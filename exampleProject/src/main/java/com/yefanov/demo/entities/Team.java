package com.yefanov.demo.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    private Set<Footballer> players;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Footballer> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Footballer> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
