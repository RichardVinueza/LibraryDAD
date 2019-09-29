/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author AlumnadoTarde
 */
public class Conexion {
    public Conexion(){
        
    }
    private static Connection con = null;
    
    public static Connection getConexion() {
   
        //Creamos una conexión entre el programa y MySQL
        try {

            //Class.forName("com.mysql.jdbc.Driver"); esta es la otra opción para crear una conexión.
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            
            //Esta línea hace referencia a la base de datos.
            String sUrl = "jdbc:mysql://localhost:3306/libros?serverTimezone=UTC"; 
            
            con = DriverManager.getConnection(sUrl, "root", "elrincon1920");
            
        } catch (SQLException ex) {
            con = null;
            throw new RuntimeException("Error con la conexión!!!");
        }
        return con;
    }
}
