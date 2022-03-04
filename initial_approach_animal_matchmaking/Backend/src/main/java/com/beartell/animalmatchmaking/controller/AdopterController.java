package com.beartell.animalmatchmaking.controller;

import java.util.List;

import com.beartell.animalmatchmaking.domain.Adopter;
import com.beartell.animalmatchmaking.service.AdopterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/adopter")
public class AdopterController {

    @Autowired
    private AdopterService adopterService;

    @PostMapping("/add")
    public Adopter addAdopt(@RequestBody Adopter adopter) {
        return adopterService.addAdopter(adopter);
    }

    @GetMapping("/all")
    public List<Adopter> findAll() {
        return adopterService.findAll();
    }

    /*
     * The below two functions will be used for scheduling.
     * If the adopter wants to be in the scheduler list, then they
     * will be matched by a pet everyday. Otherwise, they won't receive
     * notifications of being matched => passive adopters.
     */
    @GetMapping("/match")
    public boolean scheduleForMatch(@RequestParam("username") String username) {
        return adopterService.beInMatcher(username);
    }

    @GetMapping("/doNotMatch")
    public boolean doNotScheduleForMatch(@RequestParam("username") String username) {
        return adopterService.removeFromMatcher(username);
    }

    @GetMapping("/get")
    public Adopter findAdopterByUsername(@RequestParam("username") String username) {
        return adopterService.findByUsername(username);
    }

    @DeleteMapping("/delete")
    public boolean deleteAdopterByUsername(@RequestParam("username") String username) {
        return adopterService.deleteAdopter(username);
    }
}
