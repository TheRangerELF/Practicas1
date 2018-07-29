package Unidad3_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EditarExistencia implements Initializable {

    private  int indice;
    @FXML
    private AnchorPane contenedor;

    @FXML
    private TextField cantidad;

    @FXML
    private TextField existencia;

    @FXML
    private TextField nombre;

    @FXML
    private ComboBox<String> producto;

    private ArrayList <AAAExistencia> Producto;

    @FXML
    void Actualizar(ActionEvent event) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "UPDATE productos SET"+
                "cantidad'"+cantidad.getText()+"',"+
                "costo'"+existencia.getText()+"',"+
                "nombre"+nombre.getText()+"',"+
                "WHERE idExistencias"+Producto.get(indice).getIdProducto();

    }

    @FXML
    void cancelar(ActionEvent event) {
        Pane Pane = (Pane)contenedor.getParent();
        Pane.getChildren().remove(0);
    }

    @FXML
    void eliminar(ActionEvent event) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "DELETE FROM productos WHERE idProducto" + Producto.get(indice).getIdProducto();

        statement.execute(sql);
        statement.close();
        connection.close();

        producto.getItems().remove(indice);
        Producto.remove(indice);

        nombre.setText("");
        existencia.setText("");
        cantidad.setText("");


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "Select * FFROM productos";

        ResultSet resultSet = statement.executeQuery(sql);

        Producto = new ArrayList<AAAExistencia>();
        while (resultSet.next()){
            Producto.add(new AAAExistencia(
                    resultSet.getInt("idExistencias"),
                    resultSet.getInt("idProducto"),
                    resultSet.getString("cantidad"),
                    resultSet.getString("costo"),
                    resultSet.getString("nombre")
            ));
            producto.getItems().add(String.valueOf(resultSet.getString("prodcuto")));
        }

        producto.setOnAction(event -> {
            indice = producto.getSelectionModel().getSelectedIndex();
            nombre.setText(Producto.get(indice).getNombre());
            cantidad.setText(Producto.get(indice).getCantidad());
            existencia.setText(Producto.get(indice).getCosto());
        });
        statement.close();
        connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
