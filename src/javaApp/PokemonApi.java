package javaApp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PokemonApi{

    private String url;
    public PokemonApi(String pokemonName) {
        this.url = "https://pokeapi.co/api/v2/pokemon/{pokemonName}";
        this.url = this.url.replace("{pokemonName}", pokemonName.toLowerCase());
    }


    public void getPokemonInfo() {
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

            System.out.println(content.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}