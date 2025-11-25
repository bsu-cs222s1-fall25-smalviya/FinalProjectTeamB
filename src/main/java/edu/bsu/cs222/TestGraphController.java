package edu.bsu.cs222;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TestGraphController implements Initializable {

    public LineChart SimulationGraph;
    @FXML
    private LineChart<Number, Number> lineChart;
    @FXML
    private NumberAxis xAxis;
    @FXML
    private NumberAxis yAxis;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        xAxis.setLabel("Probability");
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(0.0);
        xAxis.setUpperBound(1.0);

        yAxis.setLabel("No. of Pulls until Success");
        yAxis.setAutoRanging(true);

        lineChart.setTitle("Gacha Simulation");

        lineChart.getData().addAll(getGachaSimData());

    }

    //I know this is a bad practice but this is a test and learning something new. I think im allowed to let it slide

    public static ObservableList<XYChart.Series<Number,Number>> getGachaSimData() {
        GachaPullSim gachaPullSim = new GachaPullSim();
        //I'll be adding rough numbers to test it out
        List<Integer> pullSim = gachaPullSim.userPullsSim(0.015,0.0606,20);



        GachaSimGraphData[] data = gachaPullSim.getGachaSimGraphData();


        XYChart.Series<Number,Number> gacha = new XYChart.Series<>();

        for (int i = 0; i < 10000; i++) {
            gacha.getData().addAll(new XYChart.Data<>(data[i].getNumPulls(), data[i].getRarityProbability()));
        }

        return FXCollections.observableArrayList(gacha);

    }
}
