package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import beans.Parqueaderos;
import connection.DBConnection;


public class ParqueaderoController implements IParqueaderoController {

    @Override
    public String listar(boolean ordenar,String orden) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from parqueaderos";

        if (ordenar == true) {
            sql += " order by zona " + orden;
        }

        List<String> parqueaderos = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int codigo = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                String zona = rs.getString("zona");
                String direccion = rs.getString("direccion");
                String tipo_vehiculo = rs.getString("tipo_vehiculo");
                int numero_espacios = rs.getInt("numero_espacios");
                boolean techado = rs.getBoolean("techado");

                Parqueaderos parqueadero = new Parqueaderos(codigo, nombre, zona, direccion, tipo_vehiculo, numero_espacios, techado);

                parqueaderos.add(gson.toJson(parqueadero));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(parqueaderos);

    }
    
    }