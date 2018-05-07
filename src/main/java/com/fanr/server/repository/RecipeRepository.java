package com.fanr.server.repository;

import com.fanr.server.model.Recipe;
import com.fanr.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Recipe c SET c.Name= :name," +
            " c.Contents = :contents," +
            " c.Cooking = :cooking," +
            " c.Date= :date," +
            " c.Version = c.Version + 1  WHERE c.Id = :recipeId and c.user = :User")
    int updateAddress(@Param("recipeId") int recipeId,
                      @Param("name") String name,
                      @Param("contents") String contents,
                      @Param("cooking") String cooking,
                      @Param("date") Date date,@Param("User") User User);

    @Query("SELECT c " +
            "from Recipe c" +
            " where id_user not in :User ")
    List<Recipe> findRecipesBy(@Param("User") User User);

    @Query("SELECT c " +
            "from Recipe c" +
            " where c.user = :User ")
    List<Recipe> findRecipesMy(@Param("User") User User);

    @Transactional
    @Modifying
    @Query("DELETE  FROM Recipe c where c.Id = :recipeId and c.user = :User")
    void deleteRecipe(@Param("recipeId") int recipeId, @Param("User") User User);
}
