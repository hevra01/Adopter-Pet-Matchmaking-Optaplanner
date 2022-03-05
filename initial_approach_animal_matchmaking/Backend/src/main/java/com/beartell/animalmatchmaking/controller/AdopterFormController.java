package com.beartell.animalmatchmaking.controller;

import com.beartell.animalmatchmaking.dto.FormDTO;
import com.beartell.animalmatchmaking.service.AdopterFormService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/adopterform")
public class AdopterFormController {

    @Autowired
    private AdopterFormService adopterFormService;

    @PostMapping("/add")
    public boolean createForm(@RequestBody FormDTO formDTO) {
        return adopterFormService.createForm(formDTO);
    }

    @PatchMapping("/update")
    public boolean updateForm(@RequestBody FormDTO formDTO) {
        return adopterFormService.updateForm(formDTO);
    }
}
