package com.beartell.animalmatchmaking.service;

import com.beartell.animalmatchmaking.repository.AdopterRepository;
import com.beartell.animalmatchmaking.repository.AnimalRepository;

import org.drools.compiler.lang.DRL5Expressions.relationalOp_return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.beartell.animalmatchmaking.domain.Adopter;
import com.beartell.animalmatchmaking.domain.Animal;

@Service
public class AdopterService {

    @Autowired
    private AdopterRepository adopterRepository;

    public void addAdopter(Adopter adopter) {
        adopterRepository.save(adopter);
    }

    public boolean deleteAdopter(long id) {
        adopterRepository.deleteById(id);
        return true;

        // another way
        /*
         * Optional <Adopter> adopter = adopterRepository.findbyId(id);
         * 
         * if(adopter.isPresent()))
         * adopterRepository.delete(adopter.get());
         */
    }

    public Adopter findById(long id) {
        return adopterRepository.findById(id).orElse(null);
    }

    public List<Adopter> findAll() {
        return adopterRepository.findAll();
    }

}
