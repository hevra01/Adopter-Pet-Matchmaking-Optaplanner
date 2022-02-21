package com.beartell.animalmatchmaking.controller;

import java.util.List;

import com.beartell.animalmatchmaking.domain.Adder;
import com.beartell.animalmatchmaking.service.AdderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/adder")
public class AdderController {

    // the controller needs to be autowired with the service so that it can call its methods.
    @Autowired
    private AdderService adderService;
    
    public ResponseEntity<String> addAdder(Adder adder) {
        return null;
    }

    public ResponseEntity<List<Adder>> findAll() {
        return null;
    }

    public ResponseEntity<Adder> findAdopt(@RequestParam("username") String username) {
        return null;
    }

    public ResponseEntity<String> deleteAdopt(@RequestParam("username") String username) {
        return null;
    }
}
