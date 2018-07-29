package Unidad3_4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class PuntoVenta extends Application {

    @FXML
    private Pane contenedor;

    @FXML
    void acercaDe(ActionEvent event) {

    }

    @FXML
    void editarCliente(ActionEvent event) throws IOException {
        Parent Layout = FXMLLoader.load(getClass().getResource("EditarCliente.fxml"));

        contenedor.getChildren().add(Layout);

    }

    @FXML
    void editarExintencia(ActionEvent event) throws IOException {
        Parent Layout = FXMLLoader.load(getClass().getResource("EditarExistencia.fxml"));

        contenedor.getChildren().add(Layout);

    }

    @FXML
    void editarProducto(ActionEvent event) throws IOException {
        Parent Layout = FXMLLoader.load(getClass().getResource("EditarProducto.fxml"));

        contenedor.getChildren().add(Layout);

    }

    @FXML
    void editarProveedor(ActionEvent event) throws IOException {
        Parent Layout = FXMLLoader.load(getClass().getResource("EditarProveedor.fxml"));

        contenedor.getChildren().add(Layout);


    }

    @FXML
    void nuevaExistencia(ActionEvent event) throws IOException {
        Parent Layout = FXMLLoader.load(getClass().getResource("AgregarExistencia.fxml"));
        contenedor.getChildren().add(Layout);

    }

    @FXML
    void nuevaVenta(ActionEvent event) throws IOException {
        Parent Layout = FXMLLoader.load(getClass().getResource("NuevaVenta.fxml"));

        contenedor.getChildren().add(Layout);

    }

    @FXML
    void nuevoCliente(ActionEvent event) throws IOException {
        Parent Layout = FXMLLoader.load(getClass().getResource("AgregarCliente.fxml"));

        contenedor.getChildren().add(Layout);

    }

    @FXML
    void nuevoProducto(ActionEvent event) throws IOException {
        Parent Layout = FXMLLoader.load(getClass().getResource("AgregarProducto.fxml"));

        contenedor.getChildren().add(Layout);

    }

    @FXML
    void nuevoProveedor (ActionEvent event) throws IOException {
        Parent Layout = FXMLLoader.load(getClass().getResource("AgregarProveedor.fxml"));

        contenedor.getChildren().add(Layout);

    }

    @FXML
    void salir(ActionEvent event) {
        Platform.exit();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent Layout = FXMLLoader.load(getClass().getResource("PuntoVenta.fxml"));

        Scene Escena = new Scene(Layout);
        primaryStage.setScene(Escena);
        primaryStage.setTitle("Punto de Venta ");
        primaryStage.show();
    }
}
