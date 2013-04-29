/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package photostat_fxml;

import com.drew.imaging.ImageProcessingException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JFileChooser;

/**
 *
 * @author kargm
 */
public class Photostat_FXML extends Application {
    
    private JFileChooser chooser;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Photostat v0.1");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text scenetitle = new Text("Analyze your pics!");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label folderText = new Label("Folder:");
        folderText.setAlignment(Pos.BASELINE_LEFT);
        grid.add(folderText, 0, 1);
        
        final Label folderLabel = new Label("./");
        folderLabel.setAlignment(Pos.CENTER);
        grid.add(folderLabel, 1, 1);

        final Button folderButton = new Button("Select Folder:");
        folderButton.setAlignment(Pos.CENTER);
        grid.add(folderButton, 0, 3);

        folderButton.setOnAction(new EventHandler<ActionEvent>() {
 
        @Override
        public void handle(ActionEvent e) {
            folderLabel.setText("PRESSED");
            
              DirectoryChooser dirChooser = new DirectoryChooser();
              dirChooser.setInitialDirectory(new File("/Users/kargm/Desktop"));
              
              //Show open file dialog
              File file = dirChooser.showDialog(null);
              try {
                folderLabel.setText(file.getPath());
              } catch (NullPointerException e2) {
                  System.out.println("No file selected");
              }
            }
        });
        
        Button analyzeButton = new Button("Go!");
        grid.add(analyzeButton, 1, 3);
        
        analyzeButton.setOnAction(new EventHandler<ActionEvent>() {
             @Override
            public void handle(ActionEvent e) {
             analyzer a = new analyzer();
			try {
				// Here analyze data and make call to visualization
				statistics stats = a.analyze(folderLabel.getText());
				visualization vis = new visualization();
				vis.visualize(stats);
			} catch (ImageProcessingException e1) {
				e1.printStackTrace();
			} catch (IOException ex) {
                    Logger.getLogger(Photostat_FXML.class.getName()).log(Level.SEVERE, null, ex);
             }
        }});

        Scene scene = new Scene(grid, 800, 275);
        primaryStage.setScene(scene);
        
        scene.getStylesheets().add(Photostat_FXML.class.getResource("photostat_FXML.css").toExternalForm());
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
