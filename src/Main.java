public class Main {
    public static void main(String[] args) {
 /*         Pokemon p1 = new Pokemon("Bulbassaur", "Grass, Poison", 5);
        Pokemon p2 = new Pokemon("Ivysaur", "Grass, Poison", 16);
        Pokemon p3 = new Pokemon("Venusaur", "Grass, Poison", 32);
        Pokemon p4 = new Pokemon("Charmander", "Fire", 5);
        Pokemon p5 = new Pokemon("Charmeleon", "Fire", 16);
        Pokemon p6 = new Pokemon("Charizard", "Fire, Flight", 32);
        Pokemon p7 = new Pokemon("Squirtle", "Water", 5);
        Pokemon p8 = new Pokemon("Wartortle", "Water", 16);
        Pokemon p9 = new Pokemon("Blastoise", "Water", 32);

        // Armazenar objetos com o array pokedex
        Pokemon[] pokedex = {p1, p2, p3, p4, p5, p6, p7, p8, p9};

        //Iniciar a Gui Pokedex
        new PokemonGUI(pokedex);
        */

        PokemonApi pokemonApi = new PokemonApi("SQUIRTLE");
        pokemonApi.getPokemonInfo();

    }
}