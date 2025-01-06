package dis.ufv.pokemonExamen.pokemonAPI.controller;

import dis.ufv.pokemonExamen.pokemonAPI.models.Pokemon;
import dis.ufv.pokemonExamen.pokemonAPI.services.LocalPokemonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PokemonController {
    @Autowired
    private LocalPokemonServices localPokemonServices;

    @GetMapping("/pokemon")
    public ArrayList<Pokemon> getPokemon() {

        return localPokemonServices.leeFicheroJson("src/main/resources/pokemonConId.json");
    }

    @GetMapping("/pokemon/{name}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable String name) {
        return localPokemonServices.getByName(name);
    }
}
