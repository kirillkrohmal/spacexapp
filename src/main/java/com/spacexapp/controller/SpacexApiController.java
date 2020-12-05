package com.spacexapp.controller;


import com.spacexapp.model.Launch;
import com.spacexapp.model.Rocket;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

@RestController
public class SpacexApiController {
    public SpacexApiController() throws IOException {

    }

    private JSONArray rockets = getJsonArray ("https://api.spacexdata.com/v3/rockets");
    private JSONArray launches = getJsonArray ("https://api.spacexdata.com/v3/launches");

    @GetMapping("rocketid")
    public String rocketsId() {
        return getListRocketsId();
    }

    @GetMapping("launches")
    public Launch getLaunchesByRocketId() {
        List<Rocket> rocketNames = new ArrayList<> ();
        Map<String, List<Launch>> launchesOfRockets = new HashMap<> ();
        Launch launch = new Launch ();

        for (Rocket rocketName : rocketNames) {
            List<Launch> l4r = new ArrayList<> ();

            for (int i = 0; i < launches.length (); i++) {
                JSONObject launchJson = launches.getJSONObject (i);
                JSONObject rocket = launchJson.getJSONObject ("rocket");
                String id = rocket.getString ("rocket_id");

                if (!id.equals (rocketName.rocket_id)) {
                    continue;
                }


                launch.mission_name = launchJson.getString ("mission_name");
                launch.launch_year = launchJson.getInt ("launch_year");
                //launch.links = launchJson.getJSONObject("0").getJSONArray("links");
                l4r.add (launch);

                //System.out.println(launch.mission_name + " " +  launch.launch_year + " " + launch.links);
            }
            launchesOfRockets.put (rocketName.rocket_id, l4r);
        }
        return launch;
    }

    private static JSONArray getJsonArray(String url) throws IOException {

        CloseableHttpClient instance = HttpClientBuilder.create ().build ();

        CloseableHttpResponse response = instance.execute (new HttpGet (url));
        String bodyAsString = EntityUtils.toString (response.getEntity ());

        return new JSONObject ("{\"root\":" + bodyAsString + "}").getJSONArray ("root");

        //String pageName = obj.getJSONObject("pageInfo").getString("pageName");
    }

    private String getListRocketsId() {
        Rocket rocket = new Rocket();
        for (int i = 0; i < rockets.length (); i++) {
            JSONObject rocketJson = rockets.getJSONObject (i);

            rocket.id = rocketJson.getInt ("id");
            rocket.rocket_id = rocketJson.getString ("rocket_id");
            rocket.rocket_name = rocketJson.getString ("rocket_name");
            rocket.rocket_type = rocketJson.getString ("rocket_type");

            List<Rocket> rocketNames = new ArrayList<> ();
            rocketNames.add (rocket);
        }
        return rocket.rocket_id;
    }
}

