package com.beartell.animalmatchmaking.service;

import com.beartell.animalmatchmaking.repository.AdopterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.beartell.animalmatchmaking.domain.Adopter;
import com.beartell.animalmatchmaking.domain.Form;

@Service
public class AdopterService {

    @Autowired
    private AdopterRepository adopterRepository;

    public Adopter addAdopter(Adopter adopter) {
        return adopterRepository.save(adopter);
    }

    /*
     * The below two functions will be used by the scheduler.
     * If the adopter wants to be in the matcher, then they will be regularly
     * matched
     * with pets. Otherwise, the scheduler will not be there for them. In other
     * words,
     * they will be passive adopters.
     */
    public boolean beInMatcher(String username) {
        Adopter adopter = adopterRepository.findByUsername(username);
        if (adopter != null) {
            adopter.setInMatcher(true);
            adopterRepository.save(adopter);
            return true; // Implying that the adopter has been added to the list of matchers.
        }

        // Implying that there is no adopter with the given username, so the addition
        // was not successful.
        return false;
    }

    public boolean removeFromMatcher(String username) {
        Adopter adopter = adopterRepository.findByUsername(username);
        if (adopter != null) {
            adopter.setInMatcher(false);
            adopterRepository.save(adopter);
            return true; // Implying that the adopter has been removed from the list of matchers.
        }

        // Implying that there is no adopter with the given username, so the removal was
        // not successful.
        return false;
    }

    public boolean deleteAdopter(String username) {
        if (adopterRepository.deleteByUsername(username) > 0) {
            return true;
        }
        return false;
    }

    public void createForm(Form form) {

    }

    public Adopter findByUsername(String username) {
        return adopterRepository.findByUsername(username);
    }

    public List<Adopter> findAll() {
        return adopterRepository.findAll();
    }

}
