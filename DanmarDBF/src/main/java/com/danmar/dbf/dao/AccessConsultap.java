package com.danmar.dbf.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.danmar.dbf.conn.Conexion;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class AccessConsultap {

   /**
    * Metodo para realizar la consulta con parametros a Access
    */
   public void consultap()
   {
       String sql = " SELECT (Nombre & ' ' & Paterno & ' ' & Materno) AS NombreCompleto , Universitario.Carrera, Universitario.cu "
                   + " FROM Universitario "                    
                   + " WHERE (((Universitario.Carrera) Like 'Ingenieria%') AND ((Universitario.cu) Like '[2,4,6]%')) ";
        try{
            PreparedStatement pstm = Conexion.getConn().prepareStatement( sql );
            ResultSet res = pstm.executeQuery();            
             while(res.next())
             {            
                System.out.print( res.getString( "NombreCompleto" ) );
                System.out.print( "  | " );
                System.out.print( res.getString( "Carrera" ) );
                System.out.print( "  | " );
                System.out.println( res.getString( "cu" ) );
             }
         res.close();
         
         Conexion.desconectar();
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
   }
   
   /**
    * Se ejecuta la clase de consulta
    */
    public static void main(String[] args) {
        
        AccessConsultap access = new AccessConsultap();
        access.consultap();
    }
}
