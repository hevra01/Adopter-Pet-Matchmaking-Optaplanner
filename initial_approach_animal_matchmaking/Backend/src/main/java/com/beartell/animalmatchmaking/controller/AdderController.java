package com.beartell.animalmatchmaking.controller;

import java.util.List;

import com.beartell.animalmatchmaking.domain.Adder;
import com.beartell.animalmatchmaking.service.AdderService;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Adder addAdder(@RequestBody Adder adder) {
        return adderService.saveAdder(adder);
    }

    @GetMapping("/all")
    public List<Adder> findAll() {
        return adderService.findAll();
    }

    @GetMapping("/get")
    public Adder findAdderByUsername(@RequestParam("username") String username) {
        return adderService.findByUsername(username);
    }

    @DeleteMapping("/delete")
    public boolean deleteAdderByUsername(@RequestParam("username") String username) {
        return adderService.deleteAdder(username);
    }
}
