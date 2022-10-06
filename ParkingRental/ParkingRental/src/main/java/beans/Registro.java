
package beans;

import java.util.Date;

public class Registro {
    private int codigo;
    private String cedula;
    private Date fecha;
    private String tipo_vehiculo;
    private String tiempo;
    private String placa;

    public Registro(int codigo, String cedula, Date fecha, String tipo_vehiculo, String tiempo, String placa) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.fecha = fecha;
        this.tipo_vehiculo = tipo_vehiculo;
        this.tiempo = tiempo;
        this.placa = placa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Registro{" + "codigo=" + codigo + ", cedula=" + cedula + ", fecha=" + fecha + ", tipo_vehiculo=" + tipo_vehiculo + ", tiempo=" + tiempo + ", placa=" + placa + '}';
    }
    
}
