package com.beartell.animalmatchmaking.controller;

import com.beartell.animalmatchmaking.domain.Form;
import com.beartell.animalmatchmaking.service.FormService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/form")
public class FormController {

    @Autowired
    FormService formService;

    @GetMapping("/get")
    public Form findByAdopterUsername(@RequestParam("adopterUsername") String adopterUsername) {
        return formService.findByAdopterUsername(adopterUsername);
    }
}
