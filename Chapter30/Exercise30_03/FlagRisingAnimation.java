// Modified by: Travis Dowd
// Date: 9-17-2020

import javafx.animation.PathTransition; 
import javafx.application.Application; 
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.application.Platform;

public class FlagRisingAnimation extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage)  {
		// Create a pane
		Pane pane = new Pane();
	
		// Add an image view and add it to pane
		ImageView imageView = new ImageView("image/us.gif");
		pane.getChildren().add(imageView);

		// Animate the flag using a thread
		new Thread(() ->  {
			try {
				for (int i = 0; i < 1; i++) {
					imageView.setX(10);
					imageView.setY(200);
					for (int x = 0; x <= 200; x++) {
						imageView.setY(imageView.getY() - 1);
						Thread.sleep(50);
					}
				}
			} catch (InterruptedException ex) {}
		}).start();
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 250, 200); 
		primaryStage.setTitle("FlagRisingAnimation"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}