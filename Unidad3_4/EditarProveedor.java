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

public class EditarProveedor implements Initializable {

    private  int indice;

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
    private ComboBox<String> provedores;
    private ArrayList<AAAProveedor> proveedors;

    @FXML
    void actualizar(ActionEvent event) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "UPDATE proveedores SET " +
                "nombre='" + nombre.getText() + "', " +
                "rfc='" + rfc.getText() + "', " +
                "calle='" + calle.getText() + "', " +
                "colonia='" + colonia.getText() + "', " +
                "ciudad='" + ciudad.getText() + "', " +
                "pais='" + pais.getText() + "', " +
                "telefono='" + telefono.getText() + "', " +
                "celular='" + celular.getText() + "', " +
                "email='" + correo.getText() + "' " +
                " WHERE idProveedor=" + proveedors.get(indice).
                getIdProveedor();
        statement.execute(sql);

        proveedors.get(indice).setNombre(nombre.getText());
        proveedors.get(indice).setRfc(rfc.getText());
        proveedors.get(indice).setCalle(calle.getText());
        proveedors.get(indice).setColonia(colonia.getText());
        proveedors.get(indice).setCiudad(ciudad.getText());
        proveedors.get(indice).setPais(pais.getText());
        proveedors.get(indice).setTelefono(telefono.getText());
        proveedors.get(indice).setCelular(celular.getText());
        proveedors.get(indice).setCorreo(correo.getText());

    }

    @FXML
    void cancelar(ActionEvent event) throws SQLException {
        Pane Pane = (Pane) contenedor.getParent();
        Pane.getChildren().remove(0);

    }

    @FXML
    void eliminar(ActionEvent event) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "DELETE FROM proveedores WHERE idproveedores=" + proveedors.get(indice).getIdProveedor();

        statement.execute(sql);

        statement.close();
        connection.close();

        provedores.getItems().remove(indice);
        proveedors.remove(indice);
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

            String sql = "SELECT * FROM proveedores";

            ResultSet resultSet = statement.executeQuery(sql);

            proveedors = new ArrayList<AAAProveedor>();
            while (resultSet.next()) {
                proveedors.add(new AAAProveedor(
                        resultSet.getInt("idProveedor"),
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
                provedores.getItems().add(resultSet.getString("nombre"));
            }

            provedores.setOnAction(e -> {
                indice = provedores.getSelectionModel().
                        getSelectedIndex();

                nombre.setText(proveedors.get(indice).getNombre());
                rfc.setText(proveedors.get(indice).getRfc());
                calle.setText(proveedors.get(indice).getCalle());
                colonia.setText(proveedors.get(indice).getColonia());
                ciudad.setText(proveedors.get(indice).getCiudad());
                pais.setText(proveedors.get(indice).getPais());
                telefono.setText(proveedors.get(indice).getTelefono());
                celular.setText(proveedors.get(indice).getCelular());
                correo.setText(proveedors.get(indice).getCorreo());
            });

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();


        }
    }
}
