/**
 * Represents a Pokemon object. Each has a number, a name, and two elemental
 * types, chosen from the PokemonType enumeration.
 *
 * @author  Ruben Rocha
 * @version 0.1
 */

public class Pokemon {
    private int dexNumber;
    private String pokemonName;
    private PokemonType primaryType;
    private PokemonType secondaryType;
    private int pokemonLevel;

    //Construtor vazio
    public Pokemon(){
        this.dexNumber = 25;
        this.pokemonName = "Pickachu";
        this.pokemonType = "Eletric";
        this.pokemonLevel = 5;
    }

    //Construtor
    public Pokemon(String pokemonName, String pokemonType, int pokemonLevel) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
        this.pokemonLevel = pokemonLevel;
    }

    //Methods
    public String getPokemonName() {
        return pokemonName;
    }

    public String getPokemonType() {
        return pokemonType;
    }

    public int getPokemonLevel() {
        return pokemonLevel;
    }

    public void lvlUp ()  {
        this.pokemonLevel++;
    }
    public void increaseLvlBy(int lvl){
        this.pokemonLevel += lvl;
    }
}
