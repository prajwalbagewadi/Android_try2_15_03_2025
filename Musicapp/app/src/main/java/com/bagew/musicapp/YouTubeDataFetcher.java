package com.bagew.musicapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class YouTubeDataFetcher {
    private static final String API_KEY = "YOUR_API_KEY";

    public static void fetchVideoDetails(String videoId) {
        try {
            String urlString = "https://www.googleapis.com/youtube/v3/videos?part=snippet&id="
                    + videoId + "&key=" + API_KEY;
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse JSON response
            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONArray items = jsonResponse.getJSONArray("items");
            if (items.length() > 0) {
                JSONObject snippet = items.getJSONObject(0).getJSONObject("snippet");
                String title = snippet.getString("title");
                String thumbnailUrl = snippet.getJSONObject("thumbnails")
                        .getJSONObject("high").getString("url");

                System.out.println("Title: " + title);
                System.out.println("Thumbnail URL: " + thumbnailUrl);
            } else {
                System.out.println("No video found with the provided ID.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
