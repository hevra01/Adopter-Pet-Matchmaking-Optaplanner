package com.beartell.animalmatchmaking.service;

import com.beartell.animalmatchmaking.domain.Adopter;
import com.beartell.animalmatchmaking.domain.Form;
import com.beartell.animalmatchmaking.dto.FormDTO;
import com.beartell.animalmatchmaking.repository.AdopterRepository;
import com.beartell.animalmatchmaking.repository.FormRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdopterFormService {

    @Autowired
    AdopterService adopterService;

    @Autowired
    FormRepository formRepository;

    @Autowired
    AdopterRepository adopterRepository;

    public boolean createForm(FormDTO formDTO) {
        Adopter adopter = adopterService.findByUsername(formDTO.getAdopterUsername());

        if (adopter == null) {
            return false; // the adopter does not exist to be able to create a form
        }

        Form form = new Form(formDTO.getAdopterUsername(), formDTO.getMoneyWillingToSpendForPetPerMonth(),
                formDTO.getPetType(), formDTO.getBusyness(), formDTO.getPhysicalActivityTimeDevote(),
                formDTO.getSocialLevel());

        formRepository.save(form);
        adopter.setForm(form);
        adopterRepository.save(adopter);
        return true;
    }

    public boolean updateForm(FormDTO formDTO) {
        // this time no need to check if the user exists because since it is
        // updating its form, logically, the user should already exist.

        Form form = formRepository.findByAdopterUsername(formDTO.getAdopterUsername());
        form.setBusyness(formDTO.getBusyness());
        form.setMoneyWillingToSpendForPetPerMonth(formDTO.getMoneyWillingToSpendForPetPerMonth());
        form.setPetType(formDTO.getPetType());
        form.setPhysicalActivityTimeDevote(formDTO.getPhysicalActivityTimeDevote());
        form.setSocialLevel(formDTO.getSocialLevel());

        formRepository.save(form);

        Adopter adopter = adopterService.findByUsername(formDTO.getAdopterUsername());

        adopter.setForm(form);
        adopterRepository.save(adopter);
        return true;
    }
}
