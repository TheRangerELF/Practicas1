package Layout;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Practica011_TreeView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TreeItem<String> Raiz,Rama1, Rama2;
        Raiz = new TreeItem<>("Alimentos");
        Raiz.setExpanded(false);

        Rama1 = CrearHijo("Vegetales",Raiz);
        Rama1.setExpanded(false);
            CrearHijo("Cebolla",Rama1);
            CrearHijo("Jitomate",Rama1);
            CrearHijo("Cilantro",Rama1);
        Rama2 = CrearHijo("Carnes",Raiz);
        Rama2.setExpanded(false);
            CrearHijo("Puerco",Rama2);

        TreeView treeView = new TreeView(Raiz);
        treeView.setShowRoot(true);
        treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                System.out.println(newValue);
            }
        });
        treeView.getSelectionModel().selectedItemProperty().addListener((o, anterior, nuevo)->{
            System.out.println(nuevo);
        });

        HBox Layout = new HBox();
        Layout.getChildren().add(treeView);

        Scene Escena = new Scene(Layout);
        primaryStage.setScene(Escena);
        primaryStage.show();
    }
    private  TreeItem<String> CrearHijo(String titulo, TreeItem Padre){
    TreeItem<String> hijo = new TreeItem<String>(titulo);
    Padre.getChildren().add(hijo);
    return hijo;
    }
}
