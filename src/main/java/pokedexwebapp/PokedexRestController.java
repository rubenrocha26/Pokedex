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

    
    /*@GetMapping("/api/data")
    public String searchPokemon(HttpServletRequest request, Model model) {
        //Get pokemonName from WebSite
        String pokemonName = request.getParameter("pokemonName");

        //Prevents null or empty name
        if (isPokemonNameNullOrEmpty(request)) {
            model.addAttribute("error", "Pokemon name cannot be empty.");
            return "pokedexWebPage";
        }

        try {
            PokedexApi pokedexApi = new PokedexApi(pokemonName);
            PokedexJsonParser pokedexJsonParser = new PokedexJsonParser(pokedexApi);
            model.addAttribute("name", pokedexJsonParser.getName());
            model.addAttribute("dexNumber", pokedexJsonParser.getDexNumber());
            model.addAttribute("primaryType", pokedexJsonParser.getPrimaryType());


            String secondaryType = pokedexJsonParser.getSecondaryType();
            if (secondaryType != null && !secondaryType.isEmpty()) {
                model.addAttribute("secondaryType", secondaryType);
            }

            model.addAttribute("imageUrl", pokedexJsonParser.getImageUrl());
            model.addAttribute("hp", pokedexJsonParser.getHp());
            model.addAttribute("attack", pokedexJsonParser.getAttack());
            model.addAttribute("defense", pokedexJsonParser.getDefense());
            model.addAttribute("specialAttack", pokedexJsonParser.getSpecialAttack());
            model.addAttribute("specialDefense", pokedexJsonParser.getSpecialDefense());
            model.addAttribute("speed", pokedexJsonParser.getSpeed());

        } catch (Exception e) {
            model.addAttribute("error", "Failed to fetch data for the specified Pokemon. Please try again.");
        }

        return "pokedexWebPage";
    }

    private boolean isPokemonNameNullOrEmpty(HttpServletRequest request){
        String pokemonName = request.getParameter("pokemonName");
        return pokemonName == null || pokemonName.trim().isEmpty();
    }*/

}