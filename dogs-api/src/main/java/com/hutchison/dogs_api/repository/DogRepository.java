package com.hutchison.dogs_api.repository;

import com.hutchison.dogs_api.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog,Long> {
}
