package com.spacexapp.controller;


import com.spacexapp.model.Launch;
import com.spacexapp.model.Rocket;
import com.spacexapp.repository.SpacexLaunchesRepository;
import com.spacexapp.repository.SpacexRocketRepository;
import com.spacexapp.service.SpacexService;
import com.spacexapp.service.SpacexServiceImpl;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

@RestController
public class SpacexApiController {
    private SpacexServiceImpl spacexService;

    @Autowired
    public SpacexApiController(SpacexServiceImpl spacexService) throws IOException {
        this.spacexService = spacexService;
    }

    private JSONArray rockets = getJsonArray ("https://api.spacexdata.com/v3/rockets");
    private JSONArray launches = getJsonArray ("https://api.spacexdata.com/v3/launches");

    @GetMapping("rocketid")
    public Rocket rocketsId() {
        Rocket rocket = new Rocket();
        for (int i = 0; i < rockets.length (); i++) {
            JSONObject rocketJson = rockets.getJSONObject (i);

            rocket.id = rocketJson.getInt ("id");
            rocket.rocket_id = rocketJson.getString ("rocket_id");

            List<Rocket> rocketNames = new ArrayList<> ();
            rocketNames.add (rocket);

            spacexService.saveRocket(rocket);
        }
        return rocket;

    }

    @GetMapping("launches/{rocket_id}")
    public Launch getLaunchesByRocketId() {
        List<Rocket> rocketNames = new ArrayList<> ();
        Launch launch = new Launch ();
        List<Launch> l4r = new ArrayList<> ();

        for (Rocket rocketName : rocketNames) {
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

                spacexService.saveLaunches(launch);
                //System.out.println(launch.mission_name + " " +  launch.launch_year + " " + launch.links);
            }

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
}

