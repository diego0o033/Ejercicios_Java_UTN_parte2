
package tp_final_java_inter;

import Conexion.Conex_Bd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author diego vargas
 */
public class Empresa_Servicio implements Metodos_Bd {
private int id_servicio;
private String nombre_;
private ArrayList<Servicio> serv;

public Empresa_Servicio(){}

    public void ingresar_Servicio(){
            Scanner ingreso_datos=new Scanner(System.in);
             serv=new ArrayList();
            
            System.out.println("Ingrese la cantidad de servicios que quiere dar de alta");
            int cantidad_serv=ingreso_datos.nextInt();
           
            for(int i=0;i<cantidad_serv;i++){
            Servicio s=new Servicio();
            System.out.println("Ingrese tipo de servicio");
            s.setTipo_servicio(ingreso_datos.next());
            System.out.println("Ingrese nombre del servicio");
            s.setNombre_software(ingreso_datos.next());
            System.out.println("Ingrese id de la empresa de servicio que va a realizar el alta del servicio");
            s.setId_empresa(ingreso_datos.nextInt());
            serv.add(s);
        }
         for(Servicio servi:serv){   
         if(verificar_S(servi)){
            System.out.println("Se ingresaron los servicios al sistema");
        
        }else{
        System.out.println("No sé ingresaron los servicios al sistema");
        }
    }
  }
    @Override
    public boolean Alta_Incidente(Incidente i) {
        return false;
    }

    @Override
    public boolean verificar_S(Servicio s) {
         Connection connec=null; 
         PreparedStatement pres=null;
         ResultSet rs=null;
     
        try{
               
               connec= Conex_Bd.devolver_Conexion();
               
               String sent_sql= "SELECT COUNT(*) FROM Servicio WHERE tipo_servicio = ?";
                
                pres=connec.prepareStatement(sent_sql);
                pres.setString(1, s.getTipo_servicio());
                rs=pres.executeQuery();
                if(rs.next()){
                   if(rs.getInt(1)>0){
                       System.out.println("el servicio ya se encuentra almacenado");
                       return false;
                   }else{ 
                       if(connec.isClosed()){
                        connec=Conex_Bd.devolver_Conexion();
                       }
                        insertar_Servicio_Bd(s);
                        return true;
                   }
                        }
     }catch(Exception e){
      JOptionPane.showMessageDialog(null, "error,los datos no fueron insertados en la bd" + e);
				
                        }           
    finally
	{
		try
		{
                    if(pres!=null)pres.close();
				
			}
	catch(Exception ex)
		{
		JOptionPane.showMessageDialog(null, "se genero un error y nose pudo cerrar la conexion" + ex);
					}
    }
     return false;
    }
    @Override
    public boolean insertar_Servicio_Bd(Servicio s) {
        Connection connec=null; 
        PreparedStatement pres=null;
        
        try{
                connec=Conex_Bd.devolver_Conexion();
               
                String sent_sql= "insert into Servicio(tipo_servicio,nombre_software,id_empresa)";
                sent_sql+= "values (?,?,?)";
                
                pres=connec.prepareStatement(sent_sql);
                pres.setString(1, s.getTipo_servicio());
                pres.setString(2, s.getNombre_software());
                pres.setInt(3, s.getId_empresa());
                pres.execute();
                return true;
            }catch(Exception e){
              JOptionPane.showMessageDialog(null, "error,los datos no fueron insertados en la bd" + e);
				return false;
                        }  
    finally
        {
            try
               {
                 if(pres!=null)pres.close();                     
                }catch(Exception ex)
		{
		JOptionPane.showMessageDialog(null, "se genero un error y nose pudo cerrar la conexion" + ex);
					}
        }   
    }    
    @Override
    public boolean asociar_Servicio_Cliente(int id_servicio, int id_cliente) {
       return false;
    }

    @Override
    public boolean verificar_C(Cliente c) {
        return false;
    }

    @Override
    public boolean insertar_Registro_Cliente_Bd(Cliente clien) {
        return false;
    } 

    @Override
    public int obtener_Id_Cliente(Cliente c) {
        return 0;
    }
}
