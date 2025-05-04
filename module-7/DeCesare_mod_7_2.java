// Anton DeCesare mod 7.2
// This JavaFX program displays four styled circles in a horizontal layout.
// Two circles are plain with borders, while the other two are filled with red and green. Styles are applied using an external CSS file.

package com.example.adecesare_mod_7_2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.net.URL;

public class DeCesare_mod_7_2 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create first white circle with black stroke from CSS class
        Circle c1 = new Circle(30);
        c1.getStyleClass().add("plaincircle");

        // Create second white circle with black stroke
        Circle c2 = new Circle(30);
        c2.getStyleClass().add("plaincircle");

        // Create third circle and apply red fill and stroke via CSS ID
        Circle c3 = new Circle(30);
        c3.setId("redcircle");

        // Create fourth circle and apply green fill and stroke via CSS ID
        Circle c4 = new Circle(30);
        c4.setId("greencircle");

        // Group the first two circles vertically and add a border via CSS
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(c1, c2);
        vbox.getStyleClass().add("border");

        // Place the VBox and remaining two circles horizontally with spacing
        HBox hbox = new HBox(15);
        hbox.getChildren().addAll(vbox, c3, c4);
        hbox.setStyle("-fx-padding: 20;"); // Add some padding around the layout

        // Create the scene and apply the external stylesheet if found
        Scene scene = new Scene(hbox);
        URL css = getClass().getResource("/com/example/DeCesare_mod_7_2.css");
        if (css == null) {
            System.err.println("CSS file not found! Check path: /com/example/DeCesare_mod_7_2.css");
        } else {
            scene.getStylesheets().add(css.toExternalForm());
        }

        // Finalize and show the stage
        primaryStage.setTitle("Styled Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Main method launches the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}
