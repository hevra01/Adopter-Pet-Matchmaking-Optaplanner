package com.beartell.animalmatchmaking.score;

import java.util.HashSet;
import java.util.Set;

import com.beartell.animalmatchmaking.domain.Adopter;
import com.beartell.animalmatchmaking.domain.AdopterPetPair;

import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.calculator.EasyScoreCalculator;

public class ScoreCalculator implements EasyScoreCalculator<AdopterPetPair, HardSoftScore> {

    @Override
    public HardSoftScore calculateScore(AdopterPetPair adopterPetPair) {
        int hardScore = 0;
        int softScore = 0;

        Set<String> occupiedRooms = new HashSet<>();
        for (Adopter adopter : adopterPetPair.getAdoptersInMatcher()) {
            hardScore += -1;
        }

        return HardSoftScore.of(hardScore, softScore);
    }
}
