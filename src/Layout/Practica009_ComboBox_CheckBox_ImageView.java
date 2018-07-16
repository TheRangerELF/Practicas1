package Layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Practica009_ComboBox_CheckBox_ImageView extends Application {
    public static void main (String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.getItems().add("Batman");
        comboBox.getItems().add("NightWing");
        comboBox.getItems().add("No click");
        comboBox.getItems().add("No clic x2");
        comboBox.setPromptText("Seleccionar Imagen");

        comboBox.setOnAction(event -> {
            System.out.println(comboBox.getValue());

            int id= comboBox.getSelectionModel().getSelectedIndex();
            System.out.println("el indice es"+id);
        });

        CheckBox checkBox =new CheckBox();
        checkBox.setText("Cambiar imagen");
        checkBox.setSelected(false);
        checkBox.setOnAction(event -> {
            if (checkBox.isSelected()){
            }
            else{

            }
            System.out.println(checkBox.isSelected());
        });

        Image imagenBM = new Image("imagenes/806167_download-batman-comic-new-52-wallpapers-desktop-backgrounds_900x1366_h.jpg");
        Image imagenNW = new Image("imagenes/Robin.jpg");
        ImageView imageView=new ImageView();
        imageView.setImage(imagenNW);
       // imageView.setImage(imagenNW);
        imageView.setFitWidth(500);
        imageView.setPreserveRatio(true);

        comboBox.setOnAction(event ->{
            if(checkBox.isSelected()) {
                if (comboBox.getSelectionModel().getSelectedIndex() == 0)
                    imageView.setImage(imagenBM);
                else {
                    imageView.setImage(imagenNW);
                }
            }
        });

        VBox Layout = new VBox();
        Layout.setPadding(new Insets(10));
        Layout.getChildren().add(comboBox);
        Layout.getChildren().add(checkBox);
        Layout.getChildren().add(imageView);

        Scene Escena =new Scene(Layout);
        primaryStage.setTitle("Elementos");
        primaryStage.setScene(Escena);
        primaryStage.show();

    }
}
