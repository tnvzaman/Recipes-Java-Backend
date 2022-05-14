package recipes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    public recipe currentRecipe;

    @PostMapping("/api/recipe")
    public void PostRecipe(@RequestBody recipe givenRecipe) {
        currentRecipe = givenRecipe;
    }

    @GetMapping("/api/recipe")
    public recipe GetRecipe() {
        return currentRecipe;
    }
}
