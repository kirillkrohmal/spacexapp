package com.spacexapp.utils;


import com.spacexapp.model.Launch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Launches {
    private final Map<String, List<Launch>> launchesByRocket = new HashMap<> ();

    public Launches(JSONArray jsonLaunches) {
        for (int i = 0; i < jsonLaunches.length(); i++) {
            JSONObject jsonLaunch = jsonLaunches.getJSONObject(i);
            JSONObject jsonRocket = jsonLaunch.getJSONObject("rocket");
            String rocketId = jsonRocket.getString("rocket_id");
            List<Launch> itsLaunches = launchesByRocket.computeIfAbsent(rocketId, k -> new ArrayList<> ());
            int launchYear = jsonLaunch.getInt("launch_year");
            String missionName = jsonLaunch.getString("mission_name");
            JSONObject jsonLinks = jsonLaunch.getJSONObject("links");
            Map<String, String> links = new HashMap<> ();
            for (String key : jsonLinks.keySet()) {
                if (jsonLinks.isNull(key)) continue;
                if (!key.equals("flickr_images")) {
                    try {
                        String value = jsonLinks.getString(key);
                        links.put(key, value);
                    } catch (JSONException ex) {
                        System.out.println("The type of link is slightly complex: " + key);
                    }
                }
            }
            Launch launch = new Launch (launchYear, missionName, links);
            itsLaunches.add(launch);
        }
    }

    public List<Launch> getByRocketId(String rocketId) {
        return launchesByRocket.get(rocketId);
    }
}
