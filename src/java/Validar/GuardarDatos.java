/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author David Oaxaca
 * @version 1.0
 */
public class GuardarDatos {
    /*
    *Se crean la variables necesarias para conectar con la base de datos
    *
    *
    */
    Connection con = null;
    Statement stat = null;
    ResultSet res = null;
    ResultSet resinfo = null;
    String usuario;
    String contra;
    String driver;
    String link;
    
    /*
    *Se asigna el valor general de las variables necesarias para conectar con la base de datos
    *
    *
    */
    public GuardarDatos(){
        this.usuario = "root";
        this.contra = "n0m3l0";
        this.driver = "com.mysql.jdbc.Driver";
        this.link = "jdbc:mysql://localhost/usuarios";
    }
    /*
    *Se conecta con la base de datos
    *
    */
    public void conectar(){
        try {
            Class.forName(this.driver).newInstance();
            con = DriverManager.getConnection(link, usuario, contra);
        } catch (Exception ex) {
            System.out.println("El Error es: " + ex.getMessage());
        }
    }
    /*
    *Cierra la coneccion con la base de datos
    *
    *
    */
    public void closeConexion() throws SQLException{
        this.con.close();
    }
    /*
    *Inserta los datos de una nueva entrada con la base de datos
    *
    *
    */
    public void insertar(String Nom, String Pass) throws SQLException{
        stat = con.createStatement();
        stat.executeUpdate("Insert into usuario values("+null+",'"+Nom+"','"+Pass+"');");
    }
    /*
    *Sirve para consultar con la base, lo iba a usar para auto incremento con un for y un int 
    *pero resulta que hay una funcion en MySQL para eso
    *
    */
    public ResultSet consultar (String consulta) throws SQLException{
        stat = con.createStatement();
        return stat.executeQuery(consulta);
    }
    
    
}