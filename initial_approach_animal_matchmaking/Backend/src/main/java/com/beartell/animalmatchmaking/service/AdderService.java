package com.beartell.animalmatchmaking.service;

import com.beartell.animalmatchmaking.repository.AdderRepository;
import com.beartell.animalmatchmaking.repository.adderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdderService {

    // the adderService needs to be autowired with the repository so that it can
    // call its methods.
    @Autowired
    private AdderRepository adderRepository;

}
