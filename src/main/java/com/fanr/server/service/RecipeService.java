package com.fanr.server.service;

import com.fanr.server.model.Recipe;
import com.fanr.server.model.User;
import com.fanr.server.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public String addRecipe(Recipe recipe, User user) {

        recipe.setDate(new Date());
        recipe.setVersion(1);
        recipe.setUser(user);
        recipeRepository.save(recipe);
        return "Ready";
    }

    public String updateRecipe(Recipe recipe, User user) {

        recipe.setDate(new Date());
        recipeRepository.updateAddress(recipe.getId(),
                recipe.getName(),
                recipe.getContents(),
                recipe.getCooking(),
                new Date(), user);
        return "Ready";
    }

    public List<Recipe> findAll(User user) {
        return recipeRepository.findRecipesBy(user);
    }

    public List<Recipe> findAllMy(User user) {
        return recipeRepository.findRecipesMy(user);
    }

    public void deleteRecipe(int id, User user)
    {
        recipeRepository.deleteRecipe(id, user);
    }

    public Integer findVersion(int id) {
      return   recipeRepository.findVersion(id);
    }

    public Recipe idInRecipe(int id) {
        return   recipeRepository.idInRecipe(id);
    }
}
