package com.hutchison.dogs_api.config;

import com.hutchison.dogs_api.model.Dog;
import com.hutchison.dogs_api.repository.DogRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DataLoader {

    private final DogRepository dogRepository;
    private final ObjectMapper objectMapper;

    public DataLoader(DogRepository dogRepository,ObjectMapper objectMapper){
        this.dogRepository=dogRepository;
        this.objectMapper=objectMapper;
    }

    @PostConstruct
    public void loader() throws Exception{
        InputStream inputStream=getClass().getResourceAsStream("/dogs.json");

        Map<String, List<String>> breedMap =
                objectMapper.readValue(inputStream, new TypeReference<>() {});

        List<Dog> dogs=new ArrayList<>();

        for(Map.Entry<String,List<String>>entry: breedMap.entrySet()){
            Dog dog=new Dog();
            dog.setBreed(entry.getKey());
            dog.setSubBreed(entry.getValue());
            dogs.add(dog);
        }

        dogRepository.saveAll(dogs);
    }

}
