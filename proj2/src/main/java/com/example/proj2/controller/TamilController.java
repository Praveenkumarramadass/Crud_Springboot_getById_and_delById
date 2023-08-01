package com.example.proj2.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proj2.model.Tamil;
import com.example.proj2.repository.TamilRepository;

@RestController
@RequestMapping("/api")

public class TamilController {
    
    @Autowired
    TamilRepository tamilRepository;

    @GetMapping("/show_user/{id}")
    public ResponseEntity<Tamil> getUserById(@PathVariable("id") Long id){
        Optional<Tamil> tamil = tamilRepository.findById(id);
        if(tamil.isPresent()){
            Tamil tl = tamil.get();
            return new ResponseEntity<Tamil>(tl,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete_user/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id){
        tamilRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
