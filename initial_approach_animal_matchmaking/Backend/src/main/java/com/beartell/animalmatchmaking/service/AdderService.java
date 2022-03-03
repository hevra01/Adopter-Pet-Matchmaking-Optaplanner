package com.beartell.animalmatchmaking.service;

import java.util.List;

import com.beartell.animalmatchmaking.domain.Adder;
import com.beartell.animalmatchmaking.repository.AdderRepository;
import com.beartell.animalmatchmaking.repository.AdderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdderService {

    // the adderService needs to be autowired with the repository so that it can
    // call its methods.
    @Autowired
    private AdderRepository adderRepository;

    public void saveAdder(Adder adder) {
        adderRepository.save(adder);
    }

    public Adder findAdder(String username) {
        return adderRepository.findByUsername(username);
    }

    public boolean deleteAdder(String username) {
        adderRepository.deleteByUsername(username);
        return true;
    }

    public List<Adder> findAll() {
        return adderRepository.findAll();
    }

}
