package edu.bsu.cs222;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GachaPullSim {
    private Random r = new Random();
    private List<Integer> pullsList = new ArrayList<>();
    private double average;

    public List<Integer> userPullsSim(double rarityProbability, double rarityPityProbability, int rarityPityCount, int userPulls){
        for (int i = 1; i <= userPulls; i++) {
            int pulls = 0;
            boolean targetFound = false;
            int pityCount = 0;
            double pullProbability = rarityProbability;

            while (targetFound == false){
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

    public double averagePullsForDesiredRarity(List<Integer> pullsList, int userPulls){
        int listSize = pullsList.size();
        int total = 0;

        for (int i = 0; i < listSize; i++) {
            total += pullsList.get(i);
        }

        average = total/userPulls;

        return average;
    }

    public double probabilityForDesiredRarity(List<Integer> pullsList, int userPulls){

        double average = averagePullsForDesiredRarity(pullsList, userPulls);

        return average/userPulls;
    }


}
