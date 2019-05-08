package com.lambdaschool.zoos.controller;


import com.lambdaschool.zoos.model.Animal;
import com.lambdaschool.zoos.model.Zoo;
import com.lambdaschool.zoos.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/animals")
public class AnimalController {


    @Autowired
    AnimalService animalService;

    @GetMapping(value = "/animals", produces = {"application/json"})
    public ResponseEntity<?> listAllAnimals()
    {
        return new ResponseEntity<>(animalService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/animals/{type}", produces = {"application/json"})
    public ResponseEntity<?> findZooByName(@PathVariable String type)

    {
        ArrayList<Animal> a = animalService.findAnimalByType(type);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @GetMapping(value = "/animalcount", produces = {"application/json"})
    public ResponseEntity<?> getCountAnimalsInZoos()
    {
        return new ResponseEntity<>(animalService.getCountAnimalsInZoos(), HttpStatus.OK);
    }

    // if there are two results returned from the animal name query you get an error. Search Bear.
    //Need a list to work around
    //Also findByZooname in Zoo repo searches the Zoo object for this.zooname likewise for findByName = this.name
    //Lots of errors in seeding didn't help either, double quotes, different field names, missing comma, incorrect tablenames
}
