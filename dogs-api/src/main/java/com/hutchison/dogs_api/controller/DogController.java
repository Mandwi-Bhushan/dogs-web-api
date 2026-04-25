package com.hutchison.dogs_api.controller;

import com.hutchison.dogs_api.model.Dog;
import com.hutchison.dogs_api.service.DogService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogs")
@CrossOrigin("*")
public class DogController {

    private final DogService dogService;

    public DogController(DogService dogService){
        this.dogService=dogService;
    }


    @Operation(summary="Get dog by id")
    @GetMapping("/{id}")
    public Dog getADog(@PathVariable Long id){
        return dogService.getDogById(id);
    }

    @Operation(summary="Get all dogs")
    @GetMapping
    public List<Dog> getAll(){
        return dogService.getAllDogs();
    }

    @Operation(summary="save a dog")
    @PostMapping
    public Dog createDog(@RequestBody Dog dog){
        return dogService.createDog(dog);
    }

    @Operation(summary="update a dog using id")
    @PutMapping("/{id}")
    public Dog updateDog(@PathVariable Long id, @RequestBody Dog dog){
        return dogService.updateDogById(id,dog);
    }

    @Operation(summary="delete a dog by id")
    @DeleteMapping("/{id}")
    public void deleteDog(@PathVariable Long id){
       dogService.deleteDogById(id);
    }

}
