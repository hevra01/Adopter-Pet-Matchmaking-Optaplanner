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

    private Constraint expenseConstraint(ConstraintFactory constraintFactory) {
        // The animal to be matched should be of the type specified by the user.
        return NULL;
    }

    private Constraint locationConstraint(ConstraintFactory constraintFactory) {
        // The animal to be matched should be of the type specified by the user.
        return NULL;
    }

    private Constraint activenessConstraint(ConstraintFactory constraintFactory) {
        // The animal to be matched should be of the type specified by the user.
        return NULL;
    }

    private Constraint busynessConstraint(ConstraintFactory constraintFactory) {
        // The animal to be matched should be of the type specified by the user.
        return NULL;
    }

    private Constraint socializingConstraint(ConstraintFactory constraintFactory) {
        // The animal to be matched should be of the type specified by the user.
        return NULL;
    }

}
