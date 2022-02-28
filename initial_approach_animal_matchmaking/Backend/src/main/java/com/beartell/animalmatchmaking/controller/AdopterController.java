package com.beartell.animalmatchmaking.controller;

import java.util.List;

import com.beartell.animalmatchmaking.domain.Adder;
import com.beartell.animalmatchmaking.domain.Adopter;
import com.beartell.animalmatchmaking.service.AdopterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/adopter")
public class AdopterController {

    @Autowired
    private AdopterService adopterService;

    @PostMapping("/add")
    public void addAdopt(@RequestBody Adopter adopter) {
        adopterService.addAdopter(adopter);
    }

    @GetMapping("/all")
    public List<Adopter> findAll() {
        return adopterService.findAll();
    }

    @GetMapping("/get")
    public Adopter findAdopt(@RequestParam("id") long id) {
        return adopterService.findById(id);
    }

    @DeleteMapping("/delete")
    public boolean deleteAdopt(@RequestParam("id") long id) {
        return adopterService.deleteAdopter(id);
    }
}
