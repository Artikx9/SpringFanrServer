package com.fanr.server.controller;

import com.fanr.server.dto.RecipeDataDTO;
import com.fanr.server.dto.RecipeResponseDataDTO;
import com.fanr.server.dto.UserDataDTO;
import com.fanr.server.dto.UserResponseDTO;
import com.fanr.server.model.Recipe;
import com.fanr.server.model.User;
import com.fanr.server.repository.RecipeRepository;
import com.fanr.server.service.RecipeService;
import com.fanr.server.service.UserService;
import com.sun.org.apache.regexp.internal.RE;
import io.swagger.annotations.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/recipe")
@Api(tags = "recipe")
public class RecipeController {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeService recipeService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @ApiOperation(value = "${RecipeController.add}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Username is already in use"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public String newRecipe(@RequestBody RecipeDataDTO recipe, HttpServletRequest req) {

        return recipeService.addRecipe(modelMapper.map(recipe, Recipe.class), userService.whoami(req));
    }

    @PostMapping("/update")
    @ApiOperation(value = "${RecipeController.update}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Username is already in use"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public String updateRecipe(@RequestBody RecipeDataDTO recipe, HttpServletRequest req) {

        return recipeService.updateRecipe(modelMapper.map(recipe, Recipe.class), userService.whoami(req));
    }

    @GetMapping("/all")
    @ApiOperation(value = "${RecipeController.all}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Username is already in use"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public List<Recipe> allRecipe(HttpServletRequest req) {
        return recipeService.findAll(userService.whoami(req));
    }

    @GetMapping("/my")
    @ApiOperation(value = "${RecipeController.my}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Username is already in use"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public List<Recipe> allRecipeMy(HttpServletRequest req) {

        return recipeService.findAllMy(userService.whoami(req));
    }

    @GetMapping(value = "/delete", params = "id")
    @ApiOperation(value = "${RecipeController.delete}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Username is already in use"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public void deleteRecipe(@RequestParam("id") int id,HttpServletRequest req) {
           recipeService.deleteRecipe(id,userService.whoami(req));
    }

    @GetMapping(value = "/version", params = "id")
    @ApiOperation(value = "${RecipeController.version}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Username is already in use"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public Integer findVersion(@RequestParam("id") int id, HttpServletRequest req) {
       return recipeService.findVersion(id);
    }

    @GetMapping(value = "/recipe", params = "id")
    @ApiOperation(value = "${RecipeController.version}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Username is already in use"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public Recipe idInRecipe(@RequestParam("id") int id, HttpServletRequest req) {
        return recipeService.idInRecipe(id);
    }
}
