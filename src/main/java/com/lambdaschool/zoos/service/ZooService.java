package com.lambdaschool.zoos.service;

import com.lambdaschool.zoos.model.Zoo;

import java.util.ArrayList;

public interface ZooService {
    ArrayList<Zoo> findAll();

    Zoo findZooByName (String name);
}
