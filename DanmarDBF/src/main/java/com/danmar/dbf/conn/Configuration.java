package com.danmar.dbf.conn;


import java.io.IOException;
import java.util.Properties;

/**
*
* @author v3rgu1
*/
public class Configuration {

   Properties properties = null;

   /** Configuration file name */
   public final static String CONFIG_FILE_NAME = "db_access_config.properties";

   /** Data base server */
   public final static String DB_PATH = "dbPath";

   /** Data base name */
   public final static String DB_NAME = "dbName";

   /** Data base user */
   public final static String DB_USER = "dbUser";

   /** Data base password */
   public final static String DB_PWD = "dbPwd";

   private Configuration() {
       this.properties = new Properties();
       try {
           properties.load(Configuration.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME));
       } catch (IOException ex) {
           ex.printStackTrace();
       }
   }//Configuration

   /**
    * Implementando Singleton
    *
    * @return
    */
   public static Configuration getInstance() {
       return ConfigurationHolder.INSTANCE;
   }

   private static class ConfigurationHolder {

       private static final Configuration INSTANCE = new Configuration();
   }

   /**
    * Retorna la propiedad de configuración solicitada
    *
    * @param key
    * @return
    */
   public String getProperty(String key) {
       return properties.getProperty(key);
   }
   
   
}