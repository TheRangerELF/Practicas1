package Unidad3_4;

public class AAACLiente {
    private int idCliente;
    private String nombre;
    private String rfc;
    private String calle;
    private String colonia;
    private String ciudad;
    private String pais;
    private String telefono;
    private String celular;
    private String correo;

    public AAACLiente(int idCliente, String nombre, String rfc, String calle, String colonia, String ciudad, String pais, String telefono, String celular, String email) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.rfc = rfc;
        this.calle = calle;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.pais = pais;
        this.telefono = telefono;
        this.celular = celular;
        this.correo = correo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return correo;
    }

    public void setEmail(String email) {
        this.correo = email;
    }
}