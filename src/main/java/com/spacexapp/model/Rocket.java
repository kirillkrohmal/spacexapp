package com.spacexapp.model;


import javax.persistence.*;

@Entity
@Table(name = "rockets")
public class Rocket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public int id;

    @Column(name = "rocket_id")
    public String rocket_id;

    public Rocket() {
    }

    public Rocket(String rocket_id) {
        this.rocket_id = rocket_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRocket_id() {
        return rocket_id;
    }

    public void setRocket_id(String rocket_id) {
        this.rocket_id = rocket_id;
    }

}
