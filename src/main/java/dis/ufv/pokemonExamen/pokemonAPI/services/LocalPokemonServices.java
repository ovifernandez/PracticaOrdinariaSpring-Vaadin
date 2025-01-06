package dis.ufv.pokemonExamen.pokemonAPI.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dis.ufv.pokemonExamen.pokemonAPI.models.Pokemon;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@Service
public class LocalPokemonServices {
    public ArrayList<Pokemon> leeFicheroJson(String fichero){
        try{
            Reader reader = Files.newBufferedReader(Paths.get(fichero));
            ArrayList<Pokemon> listaPokemon =
                    new Gson().fromJson(reader, new TypeToken<ArrayList<Pokemon>>() {}.getType());
            reader.close();
            return listaPokemon;
        }catch(Exception ex){
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }
    public ResponseEntity<Pokemon> getByName(String nombre){
        Pokemon buscado = null;
        ArrayList<Pokemon> listaPokemon = leeFicheroJson("src/main/resources/pokemonConId.json");
        for (Pokemon pokemon : listaPokemon) {
            if(nombre.equals(pokemon.getName())){
                System.out.println("Pokemon encontrado!!!");
                buscado = pokemon;
                break;
            }
        }
        return new ResponseEntity<>(buscado, HttpStatus.OK);
    }
}
