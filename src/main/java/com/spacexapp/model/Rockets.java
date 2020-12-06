package com.spacexapp.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Rockets {

    private final List<String> rockets = new ArrayList<> ();

    public Rockets(JSONArray jsonRockets) {
        for (int i = 0; i < jsonRockets.length (); i++) {
            JSONObject rocketJson = jsonRockets.getJSONObject (i);
            String rocketId = rocketJson.getString ("rocket_id");
            rockets.add(rocketId);
        }
    }

    public List<String> getRockets(){
        return rockets;
    }
}
