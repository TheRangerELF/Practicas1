package Unidad3_4;

public class AAAExistencia {

    private  int idExistencias;
    private  int idProducto;
    private String cantidad;
    private  String costo;
    private  String nombre;

    public AAAExistencia (int idExistencias, int idProducto, String cantidad, String costo, String nombre){
        this.idExistencias = idExistencias;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.costo = costo;
        this.nombre = nombre;
    }

    public int getIdExistencias() { return idExistencias; }

    public void setIdExistencias(int idExistencias) { this.idExistencias = idExistencias;
    }

    public int getIdProducto() { return idProducto; }

    public void setIdProducto(int idProducto) { this.idProducto = idProducto;
    }

    public String getCantidad() { return cantidad; }

    public void setCantidad(String cantidad) { this.cantidad = cantidad;
    }

    public String getCosto() { return costo; }

    public void setCosto(String costo) { this.costo = costo;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre;
    }
}
