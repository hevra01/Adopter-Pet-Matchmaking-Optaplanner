package com.beartell.animalmatchmaking.service;

import com.beartell.animalmatchmaking.repository.AdopterRepository;
import com.beartell.animalmatchmaking.repository.AnimalRepository;

import org.drools.compiler.lang.DRL5Expressions.relationalOp_return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.beartell.animalmatchmaking.domain.Adopter;
import com.beartell.animalmatchmaking.domain.Animal;
import com.beartell.animalmatchmaking.domain.Form;

@Service
public class AdopterService {

    @Autowired
    private AdopterRepository adopterRepository;

    public void addAdopter(Adopter adopter) {
        adopterRepository.save(adopter);
    }

    /*
     * The below two functions will be used by the scheduler.
     * If the adopter wants to be in the matcher, then they will be regularly
     * matched
     * with pets. Otherwise, the scheduler will not be there for them. In other
     * words,
     * they will be passive adopters.
     */
    public void beInMatcher(String username) {
        Adopter adopter = adopterRepository.findByUsername(username);
        adopter.setInMatcher(true);
        adopterRepository.save(adopter);
    }

    public void removeFromMatcher(String username) {
        Adopter adopter = adopterRepository.findByUsername(username);
        adopter.setInMatcher(false);
        adopterRepository.save(adopter);
    }

    public boolean deleteAdopter(String username) {
        adopterRepository.deleteByUsername(username);
        return true;
    }

    public void createForm(Form form) {

    }

    public Adopter findById(long id) {
        return adopterRepository.findById(id).orElse(null);
    }

    public Adopter findByUsername(String username) {
        return adopterRepository.findByUsername(username);
    }

    public List<Adopter> findAll() {
        return adopterRepository.findAll();
    }

}
