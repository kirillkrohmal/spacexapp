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
import java.util.*;

@SpringBootApplication
public class SpacexappApplication {
	public static void main(String[] args) {
		SpringApplication.run (SpacexappApplication.class, args);
	}
}
