/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author AlumnadoTarde
 */
public class ModeloPrincipal {

    private final Connection con = (Connection) Conexion.getConexion();
    private ResultSet rs = null;
    
    //Son query que nos sirven para hacer consultas desde java a MySQL
    private final String sqlSelect = "select * from alumnos";
    private String sqlDelete = "delete from alumnos where registro=";
    private String sqlUpdate = "";

    public ResultSet ejecutar_consulta() {

        //Se ejecuta una consulta en MySQL y luego ese conjunto de resultados se lo pasamos a rs que au vez pasa por el 
        //controlador y llega a la vista.
        try {
            
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sqlSelect);

        } catch (SQLException ex) {
        }
        return rs;
    }

    public void deleteData(String registro) {
        sqlDelete += registro;
        if (Ejecutar_Sql_Actualizacion(sqlDelete) > 0) {
            JOptionPane.showMessageDialog(null, "Baja Correcta");
        } else {
            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }
    }

    
    public int Ejecutar_Sql_Actualizacion(String sql) {
        int i;
        try {
            Statement stmt = con.createStatement();
            JOptionPane.showMessageDialog(null, sql);
            i = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            i = 0;
        }
        return i;
    }

    public void UpdateData(String registro, String dni, String nombre, String apellido1, String apellido2) {
        sqlUpdate = "update alumnos set dni='" + dni + "', nombre='" + nombre + "', "
                + "apellido1='" + apellido1 + "', apellido2='" + apellido2 + "' "
                + "where registro=" + registro;

        if (Ejecutar_Sql_Actualizacion(sqlUpdate) > 0) {
            JOptionPane.showMessageDialog(null, "Modificación Correcta");
        } else {
            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }
    }

}
