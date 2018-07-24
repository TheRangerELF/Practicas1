package Unidad3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class InicioSesionBD  extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent Layout = FXMLLoader.load(getClass().getResource("InicioSesion.fxml"));
        Scene Escena = new Scene(Layout);
        primaryStage.setScene(Escena);
        primaryStage.setTitle("Inicio de sesion");
        primaryStage.show();
    }

        @FXML
        private TextField usuario;

        @FXML
        private TextField clave;

        @FXML
        void bConectar(ActionEvent event) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:basedatos1.db");
                Statement statement = connection.createStatement();
                statement.setQueryTimeout(30);  // set timeout to 30 sec.
                String usr = usuario.getText();
                String clv = clave.getText();

                String consulta = "SELECT * FROM usuarios " +
                        "WHERE correo='"+usr+"' AND clave='"+clv+"' ";


                ResultSet rs = statement.executeQuery(consulta);
                if(rs.next()) {

                    System.out.println("Usuario correcto: "+ rs.getString("nombre"));

                }
                else {
                    System.out.println("Usuario no correcto: ");
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }


