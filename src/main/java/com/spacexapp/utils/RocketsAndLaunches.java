package com.spacexapp.utils;

import com.spacexapp.model.Rockets;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class RocketsAndLaunches {
    @Bean
    Rockets getRockets() throws IOException {
        JSONArray jsonRockets = getJsonArray("https://api.spacexdata.com/v3/rockets");
        return new Rockets(jsonRockets);
    }

    @Bean
    Launches getLaunches() throws IOException {
        JSONArray jsonLaunches = getJsonArray("https://api.spacexdata.com/v3/launches");
        return new Launches(jsonLaunches);
    }

    private static JSONArray getJsonArray(String url) throws IOException {
        CloseableHttpClient instance = HttpClientBuilder.create ().build ();
        CloseableHttpResponse response = instance.execute (new HttpGet (url));
        String bodyAsString = EntityUtils.toString (response.getEntity ());
        return new JSONObject ("{\"root\":" + bodyAsString + "}").getJSONArray ("root");
    }
}
