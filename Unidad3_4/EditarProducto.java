package Unidad3_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.ConnectException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EditarProducto implements Initializable {

    private  int indice;

    @FXML
    private AnchorPane contenedor;

    @FXML
    private TextField nombre;

    @FXML
    private TextField descripcion;

    @FXML
    private ComboBox<String> producto;

    private  ArrayList <AAAProducto>  Producto;

    @FXML
    void Actualizar(ActionEvent event) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "UPDATE productos SET"+
                "nombre'"+nombre.getText()+"',"+
                "descripcion'"+descripcion.getText()+"',"+
                "WHERE idProducto"+Producto.get(indice).getIdProducto();
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
        descripcion.setText("");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");
                Statement statement = connection.createStatement();
                statement.setQueryTimeout(60);

                String sql = "Select * FFROM productos";

                ResultSet resultSet = statement.executeQuery(sql);

                Producto = new ArrayList<AAAProducto>();
                while (resultSet.next()){
                    Producto.add(new AAAProducto(
                            resultSet.getInt("idProducto"),
                            resultSet.getInt("idProveedor"),
                            resultSet.getString("nombre"),
                            resultSet.getString("descripcion")
                    ));
                    producto.getItems().add(String.valueOf(resultSet.getString("prodcuto")));
                }

                producto.setOnAction(event -> {
                    indice = producto.getSelectionModel().getSelectedIndex();
                    nombre.setText(Producto.get(indice).getNombre());
                    descripcion.setText(Producto.get(indice).getDescripcion());
                });
                statement.close();
                connection.close();


            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
}
