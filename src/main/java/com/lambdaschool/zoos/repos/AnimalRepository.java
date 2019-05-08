package com.lambdaschool.zoos.repos;

import com.lambdaschool.zoos.model.Animal;
import com.lambdaschool.zoos.model.Zoo;
import com.lambdaschool.zoos.view.CountAnimalsInZoos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AnimalRepository extends CrudRepository<Animal,Long> {

    ArrayList<Animal> findByAnimaltype(String type);

    @Query(value = "SELECT a.animalid,a.animaltype FROM animal a LEFT JOIN zooanimals z ON a.animalid=z.animalid;", nativeQuery = true)
    ArrayList<CountAnimalsInZoos> getCountStudentsInCourse();
}
