package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class TestGachaPullSim {

    @Test
    public void TestBasicGachaPullSimFunctionality(){
        GachaPullSim pullSim = new GachaPullSim();
        List<Integer> resultList = pullSim.userPullsSim(0.05,0.0606,20);

        Assertions.assertNotNull(resultList);
    }

    @Test
    public void TestGachaPullSimNoPityAveragePulls(){
        GachaPullSim pullSim = new GachaPullSim();
        List<Integer> resultList = pullSim.userPullsSim(0.05,0,0);

        double resultPulls = pullSim.averagePullsForDesiredRarity(resultList);

        Assertions.assertNotNull(resultPulls);
    }

    @Test
    public void TestGachaPullSimAveragePulls(){
        GachaPullSim pullSim = new GachaPullSim();
        List<Integer> resultList = pullSim.userPullsSim(0.05,0.0606,20);

        double resultPulls = pullSim.averagePullsForDesiredRarity(resultList);

        Assertions.assertNotNull(resultPulls);
    }

    @Test
    public void TestGachaPullSimProbabilityPity(){
        GachaPullSim pullSim = new GachaPullSim();
        List<Integer> resultList = pullSim.userPullsSim(0.05,0.0606,20);

        double resultProbability = pullSim.probabilityForDesiredRarity(resultList);

        Assertions.assertNotNull(resultProbability);
    }

    @Test
    public void TestGachaPullSimProbabilityNoPity(){
        GachaPullSim pullSim = new GachaPullSim();
        List<Integer> resultList = pullSim.userPullsSim(0.05,0,0);

        double resultProbability = pullSim.probabilityForDesiredRarity(resultList);
        System.out.println(resultProbability);

        Assertions.assertNotNull(resultProbability);
    }


}
