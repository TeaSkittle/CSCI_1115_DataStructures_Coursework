// Modified by: Travis Dowd
// Date 9-22-2020
//
// Chapter 31, exercise 31_9

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;import java.io.*;
import java.net.*;
import javafx.scene.input.KeyCode;
import javafx.application.Platform;

public class Exercise31_09Client extends Application {
  private TextArea taServer = new TextArea();
  private TextArea taClient = new TextArea();
 
  DataOutputStream toServer = null;
  DataInputStream fromServer = null;
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    taServer.setWrapText(true);
    taClient.setWrapText(true);
    taServer.setDisable(true);

    BorderPane pane1 = new BorderPane();
    pane1.setTop(new Label("History"));
    pane1.setCenter(new ScrollPane(taServer));
    BorderPane pane2 = new BorderPane();
    pane2.setTop(new Label("New Message"));
    pane2.setCenter(new ScrollPane(taClient));
    
    VBox vBox = new VBox(5);
    vBox.getChildren().addAll(pane1, pane2);

    // Create a scene and place it in the stage
    Scene scene = new Scene(vBox, 200, 200);
    primaryStage.setTitle("Exercise31_09Client"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    // ----------------
    //    Networking
    // ----------------
    taClient.setOnKeyPressed( e -> {
      if (e.getCode() == KeyCode.ENTER) {
        new Thread(() -> { 
          try {
            String message = taClient.getText().trim();
            toServer.writeUTF(message);
            taServer.appendText("C:  " + message + "\n");
            taClient.clear();
            toServer.flush();
          }
          catch (IOException ex) {
            System.err.println(ex);
          }
        }).start();
      }
    });
    new Thread(() -> {
      try {
        Socket socket = new Socket("localhost", 8000);
        toServer = new DataOutputStream(socket.getOutputStream());
        fromServer = new DataInputStream(socket.getInputStream());
        while (true) {
          String message = fromServer.readUTF();
          taServer.appendText("S:  " + message + "\n");
        }
      } catch (IOException ex ) {
        taServer.appendText(ex.toString().trim() + "\n");
      }
    }).start();
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
