package com.lambdaschool.zoos.service;

import com.lambdaschool.zoos.model.Animal;
import com.lambdaschool.zoos.view.CountAnimalsInZoos;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface AnimalService {
    ArrayList<Animal> findAll();
    ArrayList<Animal> findAnimalByType(String type);
    ArrayList<CountAnimalsInZoos> getCountAnimalsInZoos();

}
