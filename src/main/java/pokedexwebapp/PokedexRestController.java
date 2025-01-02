package pokedexwebapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokedexRestController {

    @GetMapping("/api/data")
    public String getData() {
        return "Hello from Spring Boot!";
    }
}