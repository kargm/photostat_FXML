/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package photostat_fxml;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author kargm
 */
public class visualization {
    
    // TODO: Make abstract class visualizationFactory and use AbstractFactoryPattern
    
    public void visualize(statistics stats, Stage primaryStage) {
        // stub for textvis... to be replace with charts etc...
        System.out.println(stats.toString());
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(grid, 1400, 600);
        primaryStage.setScene(scene);
        
        Text fav_day_intro = new Text("You seem to be a ");
        Text fav_day_name = new Text(stats.getFavourite(stats.days_map).printName());
        Text fav_day_middle_1 = new Text(" photographer. You took ");
        Text fav_day_percent = new Text(stats.getFavourite(stats.days_map).printPercentage());
        Text fav_day_middle_2 = new Text(" % of all your pictures then.");
        fav_day_intro.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        fav_day_middle_1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        fav_day_middle_2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        fav_day_name.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        fav_day_percent.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        
        GridPane fav_day_grid = new GridPane();
        fav_day_grid.add(fav_day_intro,0,0);
        fav_day_grid.add(fav_day_name,1,0);
        fav_day_grid.add(fav_day_middle_1,2,0);
        fav_day_grid.add(fav_day_percent,3,0);
        fav_day_grid.add(fav_day_middle_2,4,0);
        
        Label fav_dayLabel = new Label("Favourite Day: " + stats.getFavourite(stats.days_map) + " pictures.");
        Label fav_monthLabel = new Label("Favourite Month: " + stats.getFavourite(stats.months_map) + " pictures.");
        Label fav_yearLabel = new Label("Favourite Year: " + stats.getFavourite(stats.year_map) + " pictures.");
        
        ObservableList<PieChart.Data> daysChartData = convertHashMapToPieChartData(stats.days_map);
        ObservableList<PieChart.Data> monthChartData = convertHashMapToPieChartData(stats.months_map);
        ObservableList<PieChart.Data> yearChartData = convertHashMapToPieChartData(stats.year_map);
        PieChart daysChart = new PieChart(daysChartData);
        PieChart monthChart = new PieChart(monthChartData);
        PieChart yearChart = new PieChart(yearChartData);
        
        daysChart.setClockwise(false);
        grid.add(daysChart,0,0);
        grid.add(monthChart,1,0);
        grid.add(yearChart,2,0);
        grid.add(fav_day_grid,0,3);
    }
    
    public ObservableList<PieChart.Data> convertHashMapToPieChartData(HashMap<String, Integer> hashmap){
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (String key : hashmap.keySet()) {
            pieChartData.add(new PieChart.Data(key, hashmap.get(key)));
        }
        return pieChartData;
    }
}
