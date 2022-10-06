
package beans;

public class Parqueaderos {
    private int codigo;    
    private String nombre;
    private String zona;
    private String direccion;
    private String tipo_vehiculo;
    private int numero_espacios;
    private boolean techado;

    public Parqueaderos(int codigo, String nombre, String zona, String direccion, String tipo_vehiculo, int numero_espacios, boolean techado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.zona = zona;
        this.direccion = direccion;
        this.tipo_vehiculo = tipo_vehiculo;
        this.numero_espacios = numero_espacios;
        this.techado = techado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public int getNumero_espacios() {
        return numero_espacios;
    }

    public void setNumero_espacios(int numero_espacios) {
        this.numero_espacios = numero_espacios;
    }

    public boolean isTechado() {
        return techado;
    }

    public void setTechado(boolean techado) {
        this.techado = techado;
    }

    @Override
    public String toString() {
        return "Parqueaderos{" + "codigo=" + codigo + ", nombre=" + nombre + ", zona=" + zona + ", direccion=" + direccion + ", tipo_vehiculo=" + tipo_vehiculo + ", numero_espacios=" + numero_espacios + ", techado=" + techado + '}';
    }   
}
