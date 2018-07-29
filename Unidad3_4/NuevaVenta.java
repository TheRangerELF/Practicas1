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

public class NuevaVenta {

    @FXML
    private AnchorPane contenedor;

    @FXML
    private TextField fecha;

    @FXML
    private TextField total;

    @FXML
    void cancelar(ActionEvent event) {
        Pane Pane = (Pane) contenedor.getParent();
        Pane.getChildren().remove(0);

    }

    @FXML
    void guardar(ActionEvent event) throws SQLException {
        Connection conecction = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");

        Statement statement = conecction.createStatement();
        statement.setQueryTimeout(60);

        String sql = " INSERT INTO ventas("+
                "fecha, total) VALUES )"+
                "'"+fecha.getText()+"'"+
                "'"+total.getText()+"'"+
                ")";
        statement.execute(sql);
        fecha.setText("");
        total.setText("");

    }

}
