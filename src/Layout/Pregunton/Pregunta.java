package Layout.Pregunton;

public class Pregunta {
    private String pregunta;
    private String [] respuesta;
    private int indiceCorrecto;

    public Pregunta(String Pregunta, String[] respuesta, int indiceCorrecto){
        this.pregunta = Pregunta;
        this.respuesta = respuesta;
        this.indiceCorrecto = indiceCorrecto;
    }
    public String getPregunta(){
        return  this.pregunta;
        }
    public String[] getRespuesta(){
        return respuesta;
    }
    public  int getIndiceCorrecto(){
        return  indiceCorrecto;
    }
}
