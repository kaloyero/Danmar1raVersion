package com.danmar.dbf.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    //contrase�a a la base de datos si es que tuviera, si no se deja vacio
//   private static final String bdPwd = Configuration.getInstance().getProperty(Configuration.DB_PWD);
   //nombre de la base de datos Acces con extension *.mdb o *.accdb
   public static final String dbName = Configuration.getInstance().getProperty(Configuration.DB_NAME)  ;
   private static final String dbPath = Configuration.getInstance().getProperty(Configuration.DB_PATH)  ;
   //direccion de la base de datos
   private static final String dbPathName = dbPath + "\\" + dbName + ";";
   //driver para base de datos Access 2000, 2003, 2007, 2010
   private static final String url = "jdbc:odbc:;DRIVER=Microsoft Access Driver (*.mdb, *.accdb);DBQ=" + dbPathName;
   
   private static final String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
   
   private static Connection conn = null;
	
   /**
    * Metodo para establecer la conexion a Access
    */
    public static void conectar() {
      try{
         //obtenemos el driver para Access 
         Class.forName(driver);
         //obtenemos la conexión         
         System.out.println("Db connect: " + url);
         conn = DriverManager.getConnection(url);
         //si la conexion tuvo exito
         if (conn!=null){
            System.out.println("Conexi�n a base de datos "+dbName+". listo");
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
	public static void desconectar(){
	    try {
	        conn.close();            
	        System.out.println("La conexion a la  base de datos " + dbName + " a terminado");
	    } catch (SQLException ex) {
	        System.out.println( ex.getMessage() );
	    }       
	}    
   
	public static Connection getConn(){
		conectar();
		return conn;
	}    
   
	
}
