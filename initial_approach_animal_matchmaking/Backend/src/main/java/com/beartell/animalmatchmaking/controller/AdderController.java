package com.beartell.animalmatchmaking.controller;

import java.util.List;

import com.beartell.animalmatchmaking.domain.Adder;
import com.beartell.animalmatchmaking.service.AdderService;

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
@RequestMapping("/api/adder")
public class AdderController {

    // the controller needs to be autowired with the service so that it can call its
    // methods.
    @Autowired
    private AdderService adderService;

    @PostMapping("/add")
    public void addAdder(@RequestBody Adder adder) {
        adderService.saveAdder(adder);
    }

    @GetMapping("/all")
    public List<Adder> findAll() {
        return adderService.findAll();
    }

    // the below getMappings need to be changed to username because
    // the below id is a technical id.
    @GetMapping("/get")
    public Adder findAdder(@RequestParam("username") String username) {
        return adderService.findAdder(username);
    }

    @DeleteMapping("/delete")
    public boolean deleteAdder(@RequestParam("username") String username) {
        return adderService.deleteAdder(username);
    }
}
