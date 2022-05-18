package recipes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@RestController
public class Controller {
    public recipe currentRecipe;
    Map<Integer, recipe> allRecipes = new HashMap<>();

    @PostMapping("/api/recipe/new")
    public ResponseEntity PostRecipe(@RequestBody recipe givenRecipe) {
        Random rand = new Random();
        int newID = rand.nextInt();
        allRecipes.put(newID, givenRecipe);
        return new ResponseEntity(Map.of("id", newID), HttpStatus.OK);
    }

    @GetMapping("/api/recipe/{id}")
    public ResponseEntity GetRecipe(@PathVariable int id) {
        if (allRecipes.containsKey(id)) {
            return new ResponseEntity(allRecipes.get(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
