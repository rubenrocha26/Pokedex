package pokedexwebapp.pokemonApi;

import org.json.JSONObject;

public class PokedexJsonParser {
    
    private String _name;
    private int _dexNumber;
    private String _primaryType;
    private String _secondaryType;
    private String _imageUrl;
    private String _jsonResponse;
    private int _hp;
    private int _attack;
    private int _defense;
    private int _specialAttack;
    private int _specialDefense;
    private int _speed;

    public PokedexJsonParser(PokedexApi pokedexApi){
        PokedexApiService pokedexApiService = new PokedexApiService(pokedexApi);
        _jsonResponse = pokedexApiService.getPokemonApiData();
        getPokemonData();
    }

    public void getPokemonData() {
        JSONObject json = new JSONObject(_jsonResponse);
        _name = json.getString("name").toLowerCase();
        _dexNumber = json.getInt("id");
        _primaryType = json.getJSONArray("types").getJSONObject(0).getJSONObject("type").getString("name");

        //Shows secondary type
        if (hasPokemonTwoTypes(_jsonResponse)){
            _secondaryType = json.getJSONArray("types").getJSONObject(1).getJSONObject("type").getString("name");
        } else {
            _secondaryType = null;
        }

        _imageUrl = json.getJSONObject("sprites").getString("front_default");

        // Parse status information
        _hp = json.getJSONArray("stats").getJSONObject(0).getInt("base_stat");
        _attack = json.getJSONArray("stats").getJSONObject(1).getInt("base_stat");
        _defense = json.getJSONArray("stats").getJSONObject(2).getInt("base_stat");
        _specialAttack = json.getJSONArray("stats").getJSONObject(3).getInt("base_stat");
        _specialDefense = json.getJSONArray("stats").getJSONObject(4).getInt("base_stat");
        _speed = json.getJSONArray("stats").getJSONObject(5).getInt("base_stat");
    }

    public String getName() {
        return _name;
    }

    public int getDexNumber() {
        return _dexNumber;
    }

    public String getPrimaryType(){
        return _primaryType;
    }

    public String getSecondaryType(){
        return _secondaryType;
    }

    public String getImageUrl(){
        return _imageUrl;
    }

    public int getHp() {
        return _hp;
    }

    public int getAttack() {
        return _attack;
    }

    public int getDefense() {
        return _defense;
    }

    public int getSpecialAttack() {
        return _specialAttack;
    }

    public int getSpecialDefense() {
        return _specialDefense;
    }

    public int getSpeed() {
        return _speed;
    }

    private boolean hasPokemonTwoTypes(String jsonResponse){
        JSONObject json = new JSONObject(jsonResponse);
        return json.getJSONArray("types").length() > 1;
    }
}
