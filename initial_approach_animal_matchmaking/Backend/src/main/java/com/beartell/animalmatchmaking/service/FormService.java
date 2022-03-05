package com.beartell.animalmatchmaking.service;

import com.beartell.animalmatchmaking.domain.Form;
import com.beartell.animalmatchmaking.repository.FormRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService {

    @Autowired
    FormRepository formRepository;

    public Form findByAdopterUsername(String username) {
        return formRepository.findByAdopterUsername(username);
    }
}
