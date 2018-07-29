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

public class EditarCLiente implements Initializable {

    private int indice;

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
    private ComboBox<String> Cliente;

    private ArrayList<AAACLiente> clientes;

    @FXML
    void actualizar(ActionEvent event) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "UPDATE clientes SET " +
                "nombre='"+nombre.getText()+"', " +
                "rfc='"+rfc.getText()+"', " +
                "calle='"+calle.getText()+"', " +
                "colonia='"+colonia.getText()+"', " +
                "ciudad='"+ciudad.getText()+"', " +
                "pais='"+pais.getText()+"', " +
                "telefono='"+telefono.getText()+"', " +
                "celular='"+celular.getText()+"', " +
                "email='"+correo.getText()+"' " +
                " WHERE idCliente="+clientes.get(indice).getIdCliente();

        statement.execute(sql);

        clientes.get(indice).setNombre(nombre.getText());
        clientes.get(indice).setRfc(rfc.getText());
        clientes.get(indice).setCalle(calle.getText());
        clientes.get(indice).setColonia(colonia.getText());
        clientes.get(indice).setCiudad(ciudad.getText());
        clientes.get(indice).setPais(pais.getText());
        clientes.get(indice).setTelefono(telefono.getText());
        clientes.get(indice).setCelular(celular.getText());
        clientes.get(indice).setEmail(correo.getText());

    }

    @FXML
    void cancelar(ActionEvent event) {
        Pane p = (Pane)contenedor.getParent();
        p.getChildren().remove(0);

    }

    @FXML
    void eliminar(ActionEvent event) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "DELETE FROM clientes WHERE idCliente=" + clientes.get(indice).getIdCliente();

        statement.execute(sql);
        statement.close();
        connection.close();

        Cliente.getItems().remove(indice);
        clientes.remove(indice);

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(60);

            String sql = "SELECT * FROM clientes";

            ResultSet resultSet = statement.executeQuery(sql);

            clientes = new ArrayList<AAACLiente>();
            while(resultSet.next()) { clientes.add(new AAACLiente(
                        resultSet.getInt("idCliente"),
                        resultSet.getString("nombre"),
                        resultSet.getString("rfc"),
                        resultSet.getString("calle"),
                        resultSet.getString("colonia"),
                        resultSet.getString("ciudad"),
                        resultSet.getString("pais"),
                        resultSet.getString("telefono"),
                        resultSet.getString("celular"),
                        resultSet.getString("email")
                ));
                Cliente.getItems().add(resultSet.getString("nombre"));
            }

            Cliente.setOnAction( e-> {
                indice = Cliente.getSelectionModel().getSelectedIndex();
                nombre.setText(clientes.get(indice).getNombre());
                rfc.setText(clientes.get(indice).getRfc());
                calle.setText(clientes.get(indice).getCalle());
                colonia.setText(clientes.get(indice).getColonia());
                ciudad.setText(clientes.get(indice).getCiudad());
                pais.setText(clientes.get(indice).getPais());
                telefono.setText(clientes.get(indice).getTelefono());
                celular.setText(clientes.get(indice).getCelular());
                correo.setText(clientes.get(indice).getEmail());
            });
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
