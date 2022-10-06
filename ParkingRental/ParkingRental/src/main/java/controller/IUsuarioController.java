package controller;

import java.util.Map;

public interface IUsuarioController {

    public String login(String cedula, String contrasena);
    
    public String register(String cedula, String contrasena,
            String nombre, String apellidos, String email, int telefono, double saldo, boolean premium);
    
    public String pedir(String cedula);

}

