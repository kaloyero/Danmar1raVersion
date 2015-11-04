package com.danmar.dbf.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class AccessMenu {

    //contraseña a la base de datos si es que tuviera, si no se deja vacio
   private String password = "";
   //nombre de la base de datos Acces con extension *.mdb o *.accdb
   private String dbName = "SMENU1.accdb";
   //direccion de la base de datos
   private String bd = "C:\\Users\\kaloye\\Desktop\\DBF\\CLIPPER" + "\\" + dbName + ";PWD=" + password;
   //private String bd = "e:\\temporal\\" + dbName + ";PWD=" + password;
   //driver para base de datos Access 2000, 2003, 2007, 2010
   private String url = "jdbc:odbc:;DRIVER=Microsoft Access Driver (*.mdb, *.accdb);DBQ=" + bd;
   private Connection conn = null;
   
   /**
    * Metodo para establecer la conexion a Access
    */
    public void conectar() {
      try{
         //obtenemos el driver para Access 
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         //obtenemos la conexión         
         conn = DriverManager.getConnection(url);
         //si la conexion tuvo exito
         if (conn!=null){
            System.out.println("Conexión a base de datos "+dbName+". listo");
         }
      }catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }
   }
        
   /**
    * Metodo para cerrar una conexion a Access
    */
   public void desconectar(){
        try {
            conn.close();            
            System.out.println("La conexion a la  base de datos " + dbName + " a terminado");
        } catch (SQLException ex) {
            System.out.println( ex.getMessage() );
        }       
   }
   
   /**
    * Metodo para realizar la consulta con parametros a Access
    */
   public void consultap()
   {
    /*   String sql = " SELECT (Nombre & ' ' & Paterno & ' ' & Materno) AS NombreCompleto , Universitario.Carrera, Universitario.cu "
                   + " FROM Universitario "                    
                   + " WHERE (((Universitario.Carrera) Like 'Ingenieria%') AND ((Universitario.cu) Like '[2,4,6]%')) ";
    */               
                   String sql = " SELECT * "
                           + " FROM SMENU WHERE opc_name like '%ul%' "                    ;

                   try{
            PreparedStatement pstm = conn.prepareStatement( sql );
            ResultSet res = pstm.executeQuery();            
             while(res.next())
             {            
                System.out.print( res.getString( "OPC_CODE" ) );
                System.out.print( "  | " );
                System.out.print( res.getString( "OPC_NAME" ) );
             }
         res.close();         
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
   }
   
   /**
    * Se ejecuta la clase de consulta
    */
    public static void main(String[] args) {
        
        AccessMenu access = new AccessMenu();
        access.conectar();
        access.consultap();
        access.desconectar();
    }
}
