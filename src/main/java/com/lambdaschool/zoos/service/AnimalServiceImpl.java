package com.lambdaschool.zoos.service;


import com.lambdaschool.zoos.model.Animal;
import com.lambdaschool.zoos.repos.AnimalRepository;
import com.lambdaschool.zoos.view.CountAnimalsInZoos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service
public class AnimalServiceImpl implements AnimalService{
    @Autowired
    AnimalRepository animalrepos;

    @Override
    public ArrayList<Animal> findAll() {
        ArrayList<Animal> list = new ArrayList<>();
        animalrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public ArrayList<CountAnimalsInZoos> getCountAnimalsInZoos() {
        return animalrepos.getCountStudentsInCourse();
    }

    @Override
    public ArrayList<Animal> findAnimalByType(String type) {
        ArrayList<Animal>alist = new ArrayList<>();
        animalrepos.findByAnimaltype(type).iterator().forEachRemaining(alist::add);

        if (alist.size() < 1)
        {
            throw new EntityNotFoundException("Restaurant " + type + " not found");
        }
        return alist;
    }
}
