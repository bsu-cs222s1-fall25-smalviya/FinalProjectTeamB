package edu.bsu.cs222;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GachaPullSim {
    private final Random r = new Random();
    private final List<Integer> pullsList = new ArrayList<>();
    private double average;
    private final int simPulls = 10000;

    public List<Integer> userPullsSim(double rarityProbability, double rarityPityProbability, int rarityPityCount){

        for (int i = 1; i <= simPulls; i++) {
            int pulls = 0;
            boolean targetFound = false;
            int pityCount = 0;
            double pullProbability = rarityProbability;

            while (!targetFound){
                if (pityCount >= rarityPityCount && rarityPityCount != 0) {
                    pullProbability = rarityPityProbability;
                }

                double pullResult = r.nextDouble();

                if (pullResult <= pullProbability) {
                    targetFound = true;
                    pityCount = 0;
                } else { pityCount += 1; }

                pulls += 1;
            }

            pullsList.add(pulls);


        }

        return pullsList;
    }

    public double averagePullsForDesiredRarity(List<Integer> pullsList){
        int total = 0;

        for (int i = 0; i < simPulls; i++) {
            total += pullsList.get(i);
        }

        average = total/simPulls;

        return average;
    }

    public double probabilityForDesiredRarity(List<Integer> pullsList){

        double average = averagePullsForDesiredRarity(pullsList);

        return average/simPulls;
    }



}
