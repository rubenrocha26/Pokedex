package pokedexwebapp;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pokedexwebapp.pokemonApi.PokedexApi;
import pokedexwebapp.pokemonApi.PokedexJsonParser;


@Controller
public class PokedexController {
    
    @GetMapping("")
    public String home() {
        return "pokedexWebPage";
    }

    @PostMapping("/pokemonSearch")
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
    }

}
