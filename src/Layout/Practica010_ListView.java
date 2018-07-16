package Layout;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Practica010_ListView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ListView<String> listView = new ListView<String>();
        ObservableList<String> elementos = FXCollections.observableArrayList();
        elementos.add("Manzana");
        elementos.add("Durazno");
        elementos.add("Platano");
        elementos.add("Sandia");
        elementos.add("Aguita de Coco");
        listView.setItems(elementos);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView.setOrientation(Orientation.HORIZONTAL);

        Button boton = new Button("Cuales estan Selecccionados");
        boton.setOnAction(event -> {
            ObservableList<String>elementosSeleccionados= listView.getSelectionModel().getSelectedItems();
            System.out.println("\n Elementos seleccionados: ");
            for(String eSelected : elementosSeleccionados)
            {
                System.out.println(eSelected);
            }
        });

        VBox layout = new VBox();
        layout.getChildren().add(listView);
        layout.getChildren().add(boton);
        Scene escena = new Scene(layout,300,100);

        primaryStage.setScene(escena);
        primaryStage.show();
    }
}
