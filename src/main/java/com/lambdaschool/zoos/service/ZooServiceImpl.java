package com.lambdaschool.zoos.service;

import com.lambdaschool.zoos.model.Zoo;
import com.lambdaschool.zoos.repos.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "zooService")

public class ZooServiceImpl implements ZooService{

    @Autowired
    ZooRepository zoorepos;

    @Override
    public ArrayList<Zoo> findAll()
    {
        ArrayList<Zoo> list = new ArrayList<>();
        zoorepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Zoo update(Zoo zoo, long zooid) {
        Zoo currentZoo = zoorepos.findById(zooid)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(zooid)));
        currentZoo.setZooname(zoo.getZooname());
        //you would update telephones w/ the telephone controller


        return zoorepos.save(currentZoo);
    }

    @Override
    public Zoo findZooByName(String name) {
        Zoo zoo = zoorepos.findByZooname(name);
        if (zoo == null)
        {
            throw new EntityNotFoundException("Restaurant " + name + " not found");
        }
        return zoo;
    }
}

