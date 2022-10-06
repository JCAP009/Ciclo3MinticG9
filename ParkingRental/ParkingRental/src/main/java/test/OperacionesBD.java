package test;
import beans.Parqueaderos;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

        
public class OperacionesBD {
    public static void main(String[] args){
    actulizarParqueadero(1,"Parqueadero Nuevo Paraiso");
    listarParqueadero();
    }
    
 public static void actulizarParqueadero(int codigo, String nombre){
    DBConnection con=new DBConnection();
    String sql="UPDATE parqueaderos SET nombre='"+nombre+"'WHERE codigo="+codigo;
    
        try {
            Statement st= con.getConnection().createStatement();
            st.executeUpdate(sql);
            
       } catch (Exception ex) {
            System.out.println(ex.getMessage());   
       }
        finally{
            con.desconectar();
        }
    }
    
    public static void listarParqueadero(){
        
     DBConnection con=new DBConnection();
     String sql="SELECT*FROM parqueaderos";
        try {
            Statement st= con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int codigo = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                String zona = rs.getString("zona");
                String direccion = rs.getString("direccion");
                String tipo_vehiculo = rs.getString("tipo_vehiculo");
                int numero_espacios = rs.getInt("numero_espacios");
                boolean techado = rs.getBoolean("techado");
                
                Parqueaderos parqueaderos=new Parqueaderos(codigo,nombre,zona,direccion,tipo_vehiculo, numero_espacios, techado);
                System.out.println(parqueaderos.toString());
            }
            st.executeQuery(sql);
       } catch (Exception ex) {
            System.out.println(ex.getMessage());   
       }
        finally{
            con.desconectar();
        }
    }
}
