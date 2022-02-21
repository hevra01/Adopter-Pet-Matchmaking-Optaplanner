package com.beartell.animalmatchmaking.controller;

import java.util.List;

import com.beartell.animalmatchmaking.domain.Adopter;
import com.beartell.animalmatchmaking.service.AdopterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdopterController {

    @Autowired
    private AdopterService adopterService;

    public ResponseEntity<String> addAdopt(Adopter adopter) {
        return null;
    }

    public ResponseEntity<List<Adopter>> findAll() {
        return null;
    }

    public ResponseEntity<Adopter> findAdopt(@RequestParam("username") String username) {
        return null;
    }

    public ResponseEntity<String> deleteAdopt(@RequestParam("username") String username) {
        return null;
    }
}
