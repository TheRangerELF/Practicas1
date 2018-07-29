package Unidad3_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AgregarProveedor {

    @FXML
    private AnchorPane contenedor;

    @FXML
    private TextField nombre;

    @FXML
    private TextField rfc;

    @FXML
    private TextField calle;

    @FXML
    private TextField colonia;

    @FXML
    private TextField ciudad;

    @FXML
    private TextField pais;

    @FXML
    private TextField telefono;

    @FXML
    private TextField celular;

    @FXML
    private TextField correo;

    @FXML
    void cancelar(ActionEvent event) {
        Pane Pane = (Pane)contenedor.getParent();
        Pane.getChildren().remove(0);

    }

    @FXML
    void guardar(ActionEvent event)  throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "INSERT INTO proveedores (" +
                "nombre, rfc, calle, colonia, ciudad," +
                "pais, telefono, celular, email) VALUES (" +
                "'" + nombre.getText() + "'," +
                "'" + rfc.getText() + "'," +
                "'" + calle.getText() + "'," +
                "'" + colonia.getText() + "'," +
                "'" + ciudad.getText() + "'," +
                "'" + pais.getText() + "'," +
                "'" + telefono.getText() + "'," +
                "'" + celular.getText() + "'," +
                "'" + correo.getText() + "'" +
                ")";
        statement.execute(sql);
        nombre.setText("");
        rfc.setText("");
        calle.setText("");
        colonia.setText("");
        ciudad.setText("");
        pais.setText("");
        telefono.setText("");
        celular.setText("");
        correo.setText("");

    }
}

