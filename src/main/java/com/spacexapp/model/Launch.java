package com.spacexapp.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "launches")
public class Launch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public int id;

    @Column(name = "mission_name")
    public String mission_name;

    @Column(name = "launch_year")
    public int launch_year;

    @Column(name = "links")
    public List<String> links;

    public Launch() {
    }

    public Launch(String mission_name, int launch_year, List<String> links) {
        this.mission_name = mission_name;
        this.launch_year = launch_year;
        this.links = links;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMission_name() {
        return mission_name;
    }

    public void setMission_name(String mission_name) {
        this.mission_name = mission_name;
    }

    public int getLaunch_year() {
        return launch_year;
    }

    public void setLaunch_year(int launch_year) {
        this.launch_year = launch_year;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }
}
