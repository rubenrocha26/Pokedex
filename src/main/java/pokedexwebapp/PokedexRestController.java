package pokedexwebapp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pokedexwebapp.pokemonApi.PokedexApi;
import pokedexwebapp.pokemonApi.PokedexJsonParser;

@RestController
public class PokedexRestController {


    @GetMapping("/api/data")
    public Map<String, Object> getData(@RequestParam String pokemonName) {
        Map<String, Object> data = new HashMap<>();

        try {
            PokedexApi pokedexApi = new PokedexApi(pokemonName);
            PokedexJsonParser pokedexJsonParser = new PokedexJsonParser(pokedexApi);

            data.put("name", pokedexJsonParser.getName());
            data.put("dexNumber", pokedexJsonParser.getDexNumber());
            data.put("primaryType", pokedexJsonParser.getPrimaryType());
            data.put("secondaryType", pokedexJsonParser.getSecondaryType());
            data.put("imageUrl", pokedexJsonParser.getImageUrl());
            data.put("hp", pokedexJsonParser.getHp());
            data.put("attack", pokedexJsonParser.getAttack());
            data.put("defense", pokedexJsonParser.getDefense());
            data.put("specialAttack", pokedexJsonParser.getSpecialAttack());
            data.put("specialDefense", pokedexJsonParser.getSpecialDefense());
            data.put("speed", pokedexJsonParser.getSpeed());

        } catch (Exception e) {
            data.put("error", "Failed to fetch data for the specified Pokemon. Please try again.");
        }

        return data;
    }
}