package com.spacexapp;

import com.spacexapp.model.Launch;
import com.spacexapp.model.Rocket;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SpacexappApplication {

	public static void main(String[] args) throws IOException {
		//SpringApplication.run(SpacexappApplication.class, args);

		JSONArray rockets = getJsonArray ("https://api.spacexdata.com/v3/rockets");
		JSONArray launches = getJsonArray ("https://api.spacexdata.com/v3/launches");

		List<Rocket> rocketNames = new ArrayList<> ();

		for (int i = 0; i < rockets.length(); i++) {
			JSONObject rocketJson = rockets.getJSONObject(i);
			Rocket rocket = new Rocket();
			rocket.id = rocketJson.getInt ("id");
			rocket.rocket_id = rocketJson.getString ("rocket_id");
			rocket.rocket_name = rocketJson.getString ("rocket_name");
			rocket.rocket_type = rocketJson.getString ("rocket_type");

			rocketNames.add(rocket);

		}

		System.out.println ("size=" + rocketNames.size());

		Map<String, List<Launch>> launchesOfRockets = new HashMap<> ();

		for (Rocket rocketName : rocketNames) {
			List<Launch> l4r = new ArrayList<> ();

			for (int i = 0; i < launches.length(); i++) {
				JSONObject launchJson = launches.getJSONObject(i);
				JSONObject rocket = launchJson.getJSONObject ("rocket");
				String id = rocket.getString ("rocket_id");

				if (!id.equals(rocketName.rocket_id)) {
					continue;
				}

				Launch launch = new Launch ();

				launch.mission_name = launchJson.getString("mission_name");
				launch.launch_year = launchJson.getInt("launch_year");
				l4r.add (launch);
				//launch.links = launchJson.getString("links");
				System.out.println(rocketName.rocket_name + " " + launch.mission_name);
			}
			launchesOfRockets.put(rocketName.rocket_id, l4r);
		}

	}

	static JSONArray getJsonArray(String url) throws IOException {

		CloseableHttpClient instance = HttpClientBuilder.create().build();

		CloseableHttpResponse response = instance.execute(new HttpGet (url));
		String bodyAsString = EntityUtils.toString(response.getEntity());

		return new JSONObject ("{\"root\":"+bodyAsString+"}").getJSONArray("root");

		//String pageName = obj.getJSONObject("pageInfo").getString("pageName");

		//System.out.println(pageName);

	}
}
