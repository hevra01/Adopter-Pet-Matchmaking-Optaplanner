package com.beartell.animalmatchmaking.solver;

import com.beartell.animalmatchmaking.service.AdopterAnimalMatchService;

import com.beartell.animalmatchmaking.domain.Adopter;
import com.beartell.animalmatchmaking.domain.Animal;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnimalConstraintProvider implements ConstraintProvider {

        @Autowired
        private AdopterAnimalMatchService adopterAnimalMatchService;

        @Override
        public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
                return new Constraint[] {
                                // Hard constraints
                                animalTypeConflict(constraintFactory),
                                expenseConstraint(constraintFactory),
                                locationConstraint(constraintFactory),
                                animalPresence(constraintFactory),
                                animalAdoptionStatus(constraintFactory),

                                // Soft constraints
                                activenessConstraint(constraintFactory),
                                busynessConstraint(constraintFactory),
                                socializingConstraint(constraintFactory)

                };
        }

        private Constraint animalTypeConflict(ConstraintFactory constraintFactory) {
                // The animal to be matched should be of the type specified by the user.

                /*
                 * The .forEach(T) building block selects every T instance that is
                 * in a problem fact collection or a planning entity collection and has no null
                 * genuine planning variables.
                 */

                return constraintFactory.forEach(Animal.class)
                                .join(Adopter.class)
                                .filter((a, b) -> a.getAnimalType() != b.getForm().getPetType())
                                .penalize("Not the correct animal type", HardSoftScore.ONE_HARD);
        }

        private Constraint animalPresence(ConstraintFactory constraintFactory) {
                // The animal to be matched should be alive.
                return constraintFactory.forEach(Animal.class)
                                .filter(animal -> animal.isAlive() == false)
                                .penalize("Animal not alive", HardSoftScore.ONE_HARD);
        }

        private Constraint expenseConstraint(ConstraintFactory constraintFactory) {
                // The expenses of the animal to be matched should be affordable by the adopter.
                return constraintFactory.forEach(Animal.class)
                                .join(Adopter.class)
                                .filter((a, b) -> a.getExpenses() > b.getForm().getMoneyWillingToSpendForPetPerMonth())
                                .penalize("Adopter can not afford the expenses", HardSoftScore.ONE_HARD);
        }

        private Constraint animalAdoptionStatus(ConstraintFactory constraintFactory) {
                // The animal to be matched shouldn't be one which is already adopted.
                // In other words, animal.adopted == false
                return constraintFactory.forEach(Animal.class)
                                .filter(animal -> animal.isAdopted() == true)
                                .penalize("Animal already adopted", HardSoftScore.ONE_HARD);
        }

        private Constraint locationConstraint(ConstraintFactory constraintFactory) {
                // The animal to be matched should be in the same country as the adopter.
                // The animal's location is the same as its adder's location.
                return constraintFactory.forEach(Animal.class)
                                .join(Adopter.class)
                                .filter((a, b) -> a.getAdder().getCountry() != b.getCountry())
                                .penalize("Location not matching", HardSoftScore.ONE_HARD);
        }

        private Constraint activenessConstraint(ConstraintFactory constraintFactory) {
                // The activeness of the animal should be in similar to its future adopter.
                return constraintFactory.forEach(Animal.class)
                                .join(Adopter.class)
                                .filter((a, b) -> a.getPhysicalActivityNeed() > b.getForm()
                                                .getPhysicalActivityTimeDevote())
                                .penalize("Activeness level not matching", HardSoftScore.ONE_SOFT,
                                                adopterAnimalMatchService.differenceInActivenessLevel());
        }

        private Constraint busynessConstraint(ConstraintFactory constraintFactory) {
                // The emotional need of the animal should be in accordance to the busyness of
                // its future adopter.
                return constraintFactory.forEach(Animal.class)
                                .join(Adopter.class)
                                .filter((a, b) -> a.getEmotionalIndependence() < b.getForm().getBusyness())
                                .penalize("Emotional need not being satisfied", HardSoftScore.ONE_SOFT,
                                                adopterAnimalMatchService.differenceInBusynessLevel());
        }

        private Constraint socializingConstraint(ConstraintFactory constraintFactory) {
                // The shyness of the animal should be in accordance to how social its future
                // adopter is.
                return constraintFactory.forEach(Animal.class)
                                .join(Adopter.class)
                                .filter((a, b) -> a.getExtroversionLevel() < b.getForm().getSocialLevel())
                                .penalize("Emotional need not being satisfied", HardSoftScore.ONE_SOFT,
                                                adopterAnimalMatchService.differenceInSocializingLevel());
        }

}
