// me falta dominar los componentes visuales de java, botones, jtextfield, jlabel, etc.
import java.sql.*; //libreria externa, driver para conectar con mysql
public class MiPrimerSelect {
    static final String DB_URL="jdbc:mysql://localhost/lista_estudiantes"; //Database - ubicacion/nombre del database
    static final String USER="root"; //usuario
    static final String password="root_bas3"; //contraseña para el ingreso
    static final String query = "Select * from Estudiantes"; //que accion desea realizar
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(DB_URL,USER,password); //conectar a la base de datos con los datos ya creados
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)){
                    while (rs.next()){
                        //mostrar en consola los datos del database
                        System.out.println("\nid: "+rs.getBigDecimal("id"));
                        System.out.println("nombre: "+rs.getString("nombre"));
                    }
        }
        catch (SQLException e){ //pertenece a la importacion del drive realizado anteriormente
                    throw new RuntimeException(e);
        }
    }
}
