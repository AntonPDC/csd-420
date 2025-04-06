/*
 * Anton DeCesare mod 1.3
 * This program is designed to use JavaFX and lambdda functions to display a random set of four cards
 *
 */



package module1FX;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    // Step 1: Create four ImageView objects to hold the images of four randomly selected cards
    ImageView card1 = new ImageView();
    ImageView card2 = new ImageView();
    ImageView card3 = new ImageView();
    ImageView card4 = new ImageView();

    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) {
        // Step 2: Set the size of each ImageView to make sure all cards are displayed uniformly
        card1.setFitWidth(100);
        card1.setPreserveRatio(true);
        card2.setFitWidth(100);
        card2.setPreserveRatio(true);
        card3.setFitWidth(100);
        card3.setPreserveRatio(true);
        card4.setFitWidth(100);
        card4.setPreserveRatio(true);

        // Step 3: Display four randomly selected cards at the start of the program
        updateCards();

        // Step 4: Create a button labeled "Refresh Cards" that will generate new random cards when clicked
        Button refreshButton = new Button("Refresh Cards");

        // Step 5: Add an event listener to the button using a lambda expression
        // When the button is clicked, the updateCards() method is executed
        refreshButton.setOnAction(event -> updateCards()); // Lambda expression used here

        // Step 6: Arrange the ImageView objects (cards) in a horizontal box layout
        HBox cardBox = new HBox(10, card1, card2, card3, card4); // 10px spacing between cards

        // Step 7: Arrange the card layout and button in a vertical box layout
        VBox layout = new VBox(20, cardBox, refreshButton); // 20px spacing between elements

        // Step 8: Create a scene to hold the layout
        Scene scene = new Scene(layout, 600, 300); // Window size set to 600x300 pixels

        // Step 9: Set up the main stage (window)
        primaryStage.setTitle("Random Card Selector"); // Title of the window
        primaryStage.setScene(scene); // Attach scene to stage
        primaryStage.show(); // Display the window
    }

    // Step 10: Define a method to randomly select four card images
    private void updateCards() {
        Random random = new Random(); // Create a Random object to generate random numbers

        // Generate four random card numbers between 1 and 52
        int cardNum1 = random.nextInt(52) + 1; // Generates a number from 1 to 52
        int cardNum2 = random.nextInt(52) + 1;
        int cardNum3 = random.nextInt(52) + 1;
        int cardNum4 = random.nextInt(52) + 1;

        // Step 11: Assign randomly selected card images to the ImageView objects
        // The images are stored in a folder called "cards" and named "1.png", "2.png", ..., "52.png"
        card1.setImage(new Image("file:cards/" + cardNum1 + ".png"));
        card2.setImage(new Image("file:cards/" + cardNum2 + ".png"));
        card3.setImage(new Image("file:cards/" + cardNum3 + ".png"));
        card4.setImage(new Image("file:cards/" + cardNum4 + ".png"));
    }

    // Step 12: The main method that launches the JavaFX application
    public static void main(String[] args) {
        launch(args); // Calls the start() method and runs the GUI
    }
}
