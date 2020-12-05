package com.spacexapp.model;


import javax.persistence.*;


public class Launch {

    public int id;

    public String mission_name;

    public int launch_year;

    public String[] links;

    public Launch() {
    }

    public Launch(String mission_name, int launch_year, String[] links) {
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

    public String[] getLinks() {
        return links;
    }

    public void setLinks(String[] links) {
        this.links = links;
    }
}
