package com.lambdaschool.zoos.repos;

import com.lambdaschool.zoos.model.Zoo;
import org.springframework.data.repository.CrudRepository;

public interface ZooRepository extends CrudRepository<Zoo,Long> {

    Zoo findByZooname(String name);
}
