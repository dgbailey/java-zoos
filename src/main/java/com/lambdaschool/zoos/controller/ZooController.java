package com.lambdaschool.zoos.controller;

import com.lambdaschool.zoos.model.Zoo;
import com.lambdaschool.zoos.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/zoos")
public class ZooController {

    @Autowired
    private ZooService zooService;

    @GetMapping(value = "/zoos", produces = {"application/json"})
    public ResponseEntity<?> listAllZoos()
    {
        return new ResponseEntity<>(zooService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/zoos/{name}", produces = {"application/json"})
    public ResponseEntity<?> findZooByName(@PathVariable String name)

    {
        Zoo z = zooService.findZooByName(name);
        return new ResponseEntity<>(z, HttpStatus.OK);
    }

    @PutMapping(value = "/admin/{zooid}")
    public ResponseEntity<?> updateCustomer(
            @RequestBody
                    Zoo updateZoo,
            @PathVariable
                    long zooid)
    {
        zooService.update(updateZoo, zooid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //dont add pointers add new objects

}
