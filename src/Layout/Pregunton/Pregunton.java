package Layout.Pregunton;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Pregunton extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    private int indicePreguntaActual;
    @Override
    public void start(Stage primaryStage) throws Exception {

        ComboBox<String> Respuesta = new ComboBox<String>();
        Respuesta.setPromptText("Escoge una respuesta");

        Label Pregunta = new Label();

        Label Resultado = new Label();

        Button BAnteriror = new Button("Anterior");
        Button BSiguiente = new Button("Siguiente");

        CheckBox MostrarRespuesta = new CheckBox("Mostrar Respuesta");

        Label RespuestaCorrecta = new Label();


        HBox LayoutBotones = new HBox();
        LayoutBotones.getChildren().addAll(BAnteriror, BSiguiente);
        LayoutBotones.setSpacing(10);
        BAnteriror.setPrefSize(95, 25);
        BSiguiente.setPrefSize(95, 25);

        VBox LayoutPrincipal = new VBox();
        LayoutPrincipal.getChildren().add(Pregunta);
        LayoutPrincipal.getChildren().add(Respuesta);
        LayoutPrincipal.getChildren().add(MostrarRespuesta);
        LayoutPrincipal.getChildren().add(LayoutBotones);
        LayoutPrincipal.getChildren().add(Resultado);
        LayoutPrincipal.getChildren().add(RespuestaCorrecta);
        LayoutPrincipal.setSpacing(5);

        Pregunta.setPrefWidth(300);
        Pregunta.setPrefHeight(50);
        Pregunta.setWrapText(true);

        RespuestaCorrecta.setPrefWidth(300);
        RespuestaCorrecta.setPrefHeight(50);
        RespuestaCorrecta.setWrapText(true);

        Respuesta.setPrefHeight(25);
        Respuesta.setPrefWidth(300);

        Resultado.setPrefWidth(300);
        Resultado.setAlignment(Pos.CENTER);

        Scene Escena = new Scene(LayoutPrincipal);
        primaryStage.setTitle("Pregunton");
        primaryStage.setScene(Escena);
        primaryStage.show();


        RespuestaCorrecta.setVisible(false);


        MostrarRespuesta.setOnAction(event -> {
            if (MostrarRespuesta.isSelected()) {
                RespuestaCorrecta.setVisible(true);
            } else {
                RespuestaCorrecta.setVisible(true);
            }
        });
        cargarPregunta();
        Pregunta.setText(pregunta.get(indicePreguntaActual).getPregunta());
        Respuesta.getItems().clear();
        for(String r : pregunta.get(indicePreguntaActual).getRespuesta()) {
            Respuesta.getItems().add(r);
        }

        Respuesta.setOnAction(e -> {
            if(Respuesta.getSelectionModel().getSelectedIndex() ==
                    pregunta.get(indicePreguntaActual).getIndiceCorrecto()
                    ) {
                Resultado.setText("Correcto");
            }else {
                Resultado.setText("Incorrecto");
            }
        });

        BSiguiente.setOnAction(e-> {
            if(indicePreguntaActual== pregunta.size()-1)
                return;
            Resultado.setText("");
            indicePreguntaActual++;
            Pregunta.setText(pregunta.get(indicePreguntaActual).getPregunta());
            Respuesta.getItems().clear();
            for(String r : pregunta.get(indicePreguntaActual).getRespuesta()) {
                Respuesta.getItems().add(r);
            }
            RespuestaCorrecta.setText(pregunta.get(indicePreguntaActual).getRespuesta()[pregunta.get(indicePreguntaActual).getIndiceCorrecto()]);
            });
        BAnteriror.setOnAction(e-> {
            if(indicePreguntaActual== 0)
                return;
            indicePreguntaActual--;
            Resultado.setText("");
            Pregunta.setText(pregunta.get(indicePreguntaActual).getPregunta());
            Respuesta.getItems().clear();
            for(String r : pregunta.get(indicePreguntaActual).getRespuesta()) {
                Respuesta.getItems().add(r);
            }

            RespuestaCorrecta.setText(pregunta.get(indicePreguntaActual).getRespuesta()[pregunta.get(indicePreguntaActual).getIndiceCorrecto()]);
        });
    }

    private void cargarPreguntas() {
        indicePreguntaActual = 0;
        pregunta = new ArrayList<Pregunta>();

    }

    private ArrayList<Pregunta> pregunta;
    private void cargarPregunta () {
        pregunta = new ArrayList<Pregunta>();
        pregunta.add(new Pregunta("¿Cuanto es 1 + 1?", new String[]{"1", "2", "3", "4"}, 1));
        pregunta.add(new Pregunta("Cuantos Planetas tiene el sistema solar", new String[]{"9", "8", "10", "5"}, 8));
        pregunta.add(new Pregunta("¿Cuantos satelites naturales tiene el planeta tierra?",new String[]{"1","2","0","5"},1));
    }

}
