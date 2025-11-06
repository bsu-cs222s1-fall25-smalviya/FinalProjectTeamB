package edu.bsu.cs222;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestGachaPullSim {

    @Test
    public void TestBasicGachaPullSimFunctionality(){
        GachaPullSim pullSim = new GachaPullSim();
        List<Integer> resultList = pullSim.userPullsSim(0.05,0.0606,20,10000);

        Assertions.assertNotNull(resultList);
    }

    @Test
    public void TestGachaPullSimNoPityAveragePulls(){
        GachaPullSim pullSim = new GachaPullSim();
        List<Integer> resultList = pullSim.userPullsSim(0.05,0,0,10000);

        double resultPulls = pullSim.averagePullsForDesiredRarity(resultList,10000);

        Assertions.assertNotNull(resultPulls);
    }

    @Test
    public void TestGachaPullSimAveragePulls(){
        GachaPullSim pullSim = new GachaPullSim();
        List<Integer> resultList = pullSim.userPullsSim(0.05,0.0606,20,10000);

        double resultPulls = pullSim.averagePullsForDesiredRarity(resultList,10000);

        Assertions.assertNotNull(resultPulls);
    }

    @Test
    public void TestGachaPullSimProbabilityPity(){
        GachaPullSim pullSim = new GachaPullSim();
        List<Integer> resultList = pullSim.userPullsSim(0.05,0.0606,20,10000);

        double resultProbability = pullSim.probabilityForDesiredRarity(resultList,10000);

        Assertions.assertNotNull(resultProbability);
    }

    @Test
    public void TestGachaPullSimProbabilityNoPity(){
        GachaPullSim pullSim = new GachaPullSim();
        List<Integer> resultList = pullSim.userPullsSim(0.05,0,0,10000);

        double resultProbability = pullSim.probabilityForDesiredRarity(resultList,10000);
        System.out.println(resultProbability);

        Assertions.assertNotNull(resultProbability);
    }


}
