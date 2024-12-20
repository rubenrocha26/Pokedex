package com.pokedex.pokedex;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.*;

import org.json.JSONObject;

public class PokemonApi{

    private String url;
    public PokemonApi(String pokemonName) {
        this.url = "https://pokeapi.co/api/v2/pokemon/{pokemonName}";
        this.url = this.url.replace("{pokemonName}", pokemonName.toLowerCase());
    }


    public void getPokemonInfoNameNumberType(JLabel resultLabel, JLabel imageLabel) {
        try {
            @SuppressWarnings("deprecation")
            URL urlObj = new URL(this.url);
            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();

            // Parse JSON response
            JSONObject json = new JSONObject(content.toString());
            String name = json.getString("name");
            int dexNumber = json.getInt("id");
            String primaryType = json.getJSONArray("types").getJSONObject(0).getJSONObject("type").getString("name");

            // Capitalize the first letter of the name
            name = name.substring(0, 1).toUpperCase() + name.substring(1);

            // Update the JLabel with the extracted information
            resultLabel.setText("Pokemon: " + name + ", Dex Number: " + dexNumber + ", Type: " + primaryType);

        } catch (Exception e) {
            resultLabel.setText("Error fetching data");
            e.printStackTrace();
        }
    }

}