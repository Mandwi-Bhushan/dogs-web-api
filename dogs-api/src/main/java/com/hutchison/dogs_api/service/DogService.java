package com.hutchison.dogs_api.service;

import com.hutchison.dogs_api.model.Dog;
import com.hutchison.dogs_api.repository.DogRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DogService {


    private final DogRepository dogRepository;
    public DogService(DogRepository dogRepository){
        this.dogRepository=dogRepository;
    }

    public Dog getDogById(Long id){
        return dogRepository.findById(id).get();
    }

    public List<Dog> getAllDogs(){
        return dogRepository.findAll();
    }

    public Dog createDog(Dog dog){

        return dogRepository.save(dog);
    }

    public Dog updateDogById(Long id, Dog newDog){
        return dogRepository.findById(id).map(d->{
            d.setSubBreed(newDog.getSubBreed());

            d.setBreed(newDog.getBreed());
            return dogRepository.save(d);
        }).orElse(null);

    }

    public void deleteDogById(Long id){
        dogRepository.deleteById(id);
    }

}
