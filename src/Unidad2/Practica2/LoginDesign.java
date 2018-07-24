package Unidad2.Practica2;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginDesign  extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent layout = FXMLLoader.load(getClass().getResource("LoginDesign.fxml"));
        Scene Escena = new Scene(layout);
        primaryStage.setTitle("Login");
        primaryStage.setScene(Escena);
        primaryStage.show();
    }
}
