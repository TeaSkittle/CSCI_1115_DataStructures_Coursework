// Modified by: Travis Dowd
// Date: 9-22-2020
//
// Exercise31_01Server.java: The server can communicate with
// multiple clients concurrently using the multiple threads
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;import java.io.*;
import java.net.*;


public class Exercise31_01Server extends Application {
  // Text area for displaying contents
  private TextArea ta = new TextArea();

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    ta.setWrapText(true);
   
    // Create a scene and place it in the stage
    Scene scene = new Scene(new ScrollPane(ta), 400, 200);
    primaryStage.setTitle("Exercise31_01Server"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    // ServerSocket stuff
    new Thread(() -> {
      try {
        // Create server socket
        ServerSocket serverSocket = new ServerSocket(8000);
        Platform.runLater(() ->
          ta.appendText("Server started at " + new Date() + '\n'));
        Socket socket = serverSocket.accept(); // listen for connection
        DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
        DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
        while (true) {
          // Get data from client
          double annualInterestRate = inputFromClient.readDouble();
          double numOfYears = inputFromClient.readDouble();
          double loanAmount = inputFromClient.readDouble();
          
          // Create loan object
          Loan loan = new Loan( annualInterestRate, (int)numOfYears, loanAmount);
          
          // send data to client
          double monthlyPayment =  loan.getMonthlyPayment();
          double totalPayment = loan.getTotalPayment();
          outputToClient.writeDouble(monthlyPayment);
          outputToClient.writeDouble(totalPayment);
          
          Platform.runLater(() -> {
            ta.appendText("Annual Interest Rate: " + annualInterestRate + "\n");
            ta.appendText("Number of years: " + numOfYears + "\n");
            ta.appendText("Loan Ammount: " + loanAmount + "\n");
            ta.appendText("monthlyPayment: " + monthlyPayment + "\n");
            ta.appendText("totalPayment: " + totalPayment + "\n");
          });
        }
      }
      catch(IOException ex){
        ex.printStackTrace();
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
