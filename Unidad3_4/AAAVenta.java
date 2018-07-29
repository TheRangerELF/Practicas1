package Unidad3_4;

import java.util.Date;

public class AAAVenta {
    private  int idVenta;
    private  int idCliente;
    private Date fecha;
    private double total;

    public AAAVenta(int idVenta, int idCliente, Date fecha, double total){
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.total = total;
    }

    public int getIdVenta() { return idVenta; }

    public void setIdVenta(int idVenta) { this.idVenta = idVenta;
    }

    public int getIdCliente() { return idCliente; }

    public void setIdCliente(int idCliente) { this.idCliente = idCliente;
    }

    public Date getFecha() { return fecha; }

    public void setFecha(Date fecha) { this.fecha = fecha;
    }

    public double getTotal() { return total; }

    public void setTotal(double total) { this.total = total;
    }
}
