package Unidad3_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AgregarExistencia {

    @FXML
    private AnchorPane contenedor;

    @FXML
    private  TextField nombre;

    @FXML
    private TextField cantidad;

    @FXML
    private TextField costo;

    @FXML
    void cancelar(ActionEvent event) {
        Pane Pane = (Pane) contenedor.getParent();

        Pane.getChildren().remove(0);

    }

    @FXML
    void guardar(ActionEvent event) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "INSERT INTO existencias(" +
                "cantidad, costo, nombre) VALUES )" +
                "'"+cantidad.getText()+"'"+
                "'"+costo.getText()+"'" +
                "'"+nombre.getText()+"'"+
                ")";
        statement.execute(sql);
        cantidad.setText("");
        costo.setText("");
        nombre.setText("");

    }

}
