package Layout;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;

public class Practica012_TableView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        javafx.scene.control.TableView<Producto> tableView;
        javafx.scene.control.TableColumn<Producto, String> columnaNombre = new javafx.scene.control.TableColumn<>("Nombre");
            columnaNombre.setMinWidth(250);
            columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));

        javafx.scene.control.TableColumn<Producto, String> columnaCosto = new javafx.scene.control.TableColumn<>("Costo");
            columnaCosto.setMinWidth(50);
            columnaCosto.setCellValueFactory(new PropertyValueFactory<>("costo"));

        javafx.scene.control.TableColumn<Producto, String> columnaExistencia = new javafx.scene.control.TableColumn<>("Existencia");
            columnaExistencia.setMinWidth(15);
            columnaExistencia.setCellValueFactory(new PropertyValueFactory<>("cantidadExistente"));

        ObservableList<Producto> elementos = FXCollections.observableArrayList();
        elementos.add(new Producto("Monitor hp",1000,20));
        elementos.add(new Producto("Teclado",200,50));
        elementos.add(new Producto("Mouse",150,70));
        tableView = new javafx.scene.control.TableView<>();
        tableView.setItems(elementos);

        tableView.getColumns().addAll(columnaNombre, columnaCosto,columnaExistencia);

        StackPane Layout = new StackPane();
        Layout.getChildren().add(tableView);
        Scene Escena= new Scene(Layout);
        primaryStage.setScene(Escena);
        primaryStage.show();

    }
    public class Producto{
        private String nombreProducto;
        private double costo;
        private int cantidadExistente;

        public Producto(){
            this.nombreProducto="";
            this.costo = 0;
            this.cantidadExistente = 0;
        }

        public Producto(String Nombre, double Costo, int Cantidad) {
            this.nombreProducto = Nombre;
            this.costo = Costo;
            this.cantidadExistente = Cantidad;
        }

        public String getNombreProducto() {
            return nombreProducto;
        }

        public void setNombreProducto(String nombreProducto) {
            nombreProducto = nombreProducto;
        }

        public double getCosto() {
            return costo;
        }

        public void setCosto(double costo) {
            costo = costo;
        }

        public int getCantidadExistente() {
            return cantidadExistente;
        }

        public void setCantidadExistente(int cantidadExistente) {
            cantidadExistente = cantidadExistente;
        }
    }
}

/*

 */