package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
/*A través de esta clase y gracias al patron de diseño Singleton, creamos una unica conexion para todas las transacciones
que debamos realizar con la bd**/
public class Conex_Bd {
 
    private static Connection conec = null;

    public static Connection devolver_Conexion() 
    {
        try 
        { 
            if (conec == null)
            {
                Runtime.getRuntime().addShutdownHook(new MiShDwnHook());
                ResourceBundle rb = ResourceBundle.getBundle("Conexion.Datos_Conexion");
                String driver= rb.getString("driver");
                String url= rb.getString("url");
                String user= rb.getString("user");
                String pass= rb.getString("pass");
                Class.forName(driver);
                conec = DriverManager.getConnection(url, user, pass);
                JOptionPane.showMessageDialog(null, "Se establecio la conexion a la BD");
             } 
          return conec;  
        }         
       
        catch (ClassNotFoundException| SQLException ex) 
                {
                    ex.printStackTrace(System.out);
                    throw new RuntimeException("no se pudo realizar la conexion con la bd", ex);
                } 
    }
    /*creamos una inner class, que extiende de thread para llamarla en el metodo addShutdownHook y así poder cerrar de forma correcta la conexion de la aplicacion a nuestra bd**/
    static class MiShDwnHook extends Thread {

        @Override
        public void run() {
            try 
            {
                conec = Conex_Bd.devolver_Conexion();
                conec.close();
            } 
            catch (SQLException ex) 
            {
                ex.printStackTrace(System.out);
                throw new RuntimeException(ex);
            }
        }
    }
}
