package com.beartell.animalmatchmaking.controller;

import com.beartell.animalmatchmaking.dto.FormDTO;
import com.beartell.animalmatchmaking.service.AdopterFormService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdopterFormController {

    @Autowired
    private AdopterFormService adopterFormService;

    public boolean createForm(FormDTO formDTO) {
        return adopterFormService.createForm(formDTO);
    }

    public boolean updateForm(FormDTO formDTO) {
        return adopterFormService.updateForm(formDTO);
    }
}
