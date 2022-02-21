package com.beartell.animalmatchmaking.solver;

import com.beartell.animalmatchmaking.domain.Animal;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;

public class AnimalConstraintProvider implements ConstraintProvider {

    private static final Constraint NULL = null;

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
        return NULL;
        /*
         * // Select a lesson ...
         * return constraintFactory
         * .forEach(Animal.class)
         * // ... and pair it with another lesson ...
         * .join(Lesson.class,
         * // ... in the same timeslot ...
         * Joiners.equal(Lesson::getTimeslot),
         * // ... in the same room ...
         * Joiners.equal(Lesson::getRoom),
         * // ... and the pair is unique (different id, no reverse pairs) ...
         * Joiners.lessThan(Lesson::getId))
         * // ... then penalize each pair with a hard weight.
         * .penalize("Room conflict", HardSoftScore.ONE_HARD);
         */
    }

    private Constraint animalPresence(ConstraintFactory constraintFactory) {
        // The animal to be matched should be alive.
        return NULL;
    }

    private Constraint expenseConstraint(ConstraintFactory constraintFactory) {
        // The expenses of the animal to be matched should be affordable by the adopter.

        return NULL;
    }

    private Constraint animalAdoptionStatus(ConstraintFactory constraintFactory) {
        // The animal to be matched shouldn't be one which is already adopted.
        // In other words, animal.adopted == false
        return NULL;
    }

    private Constraint locationConstraint(ConstraintFactory constraintFactory) {
        // The animal to be matched should be in the same country as the adopter.
        return NULL;
    }

    private Constraint activenessConstraint(ConstraintFactory constraintFactory) {
        // The activeness of the animal should be in similar to its future adopter.
        return NULL;
    }

    private Constraint busynessConstraint(ConstraintFactory constraintFactory) {
        // The emotional need of the animal should be in accordance to the busyness of
        // its future adopter.
        return NULL;
    }

    private Constraint socializingConstraint(ConstraintFactory constraintFactory) {
        // The shyness of the animal should be in accordance to how social its future
        // adopter is.
        return NULL;
    }

}
