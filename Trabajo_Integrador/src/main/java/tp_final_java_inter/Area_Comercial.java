
package tp_final_java_inter;

import Conexion.Conex_Bd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import lombok.Getter;

/**
 *
 * @author diego vargas
 */
@Getter 
public class Area_Comercial implements Metodos_Bd{
    private int id_area_comercial;
    private String nombre;
    private ArrayList<Cliente>clien;
    
    
    public Area_Comercial(){}
    /*Ingresamos un cliente, siempre y cuando no exista en nuestra bd,si lo ingresamos,luego le asociamos lo/s servicio/s que correspondan**/    
    public void ingresar_Cliente(){
             Scanner ingreso_datos=new Scanner(System.in);
             clien=new ArrayList();
            
            System.out.println("Ingrese la cantidad de clientes que quiere dar de alta");
            int cantidad_clien=ingreso_datos.nextInt();
           
            for(int i=0;i<cantidad_clien;i++){
            Cliente c=new Cliente();
            System.out.println("Ingrese un nombre para el cliente");
            c.setNombre(ingreso_datos.next());
            System.out.println("Ingrese la razon social del cliente");
            c.setDescripcion_razon_social(ingreso_datos.next());
            System.out.println("Ingrese el numero de cuit para el cliente");
            c.setCuit(ingreso_datos.nextLong());
            System.out.println("Ingrese la/s cantidad/es de servicio/s que le va a cargar al cliente"); 
            int cantidad=ingreso_datos.nextInt();
            c.setSer(cargar_Servicio_Cliente(cantidad));
            System.out.println("Ingrese el numero de id del area comercial que va a dar de alta al cliente");                     
            c.setId_area_com(ingreso_datos.nextInt());
            clien.add(c);
        }
         for(Cliente clie:clien){   
         if(verificar_C(clie)){
            System.out.println("Se ingresaron los clientes al sistema");
            if(obtener_Id_Cliente(clie)>=1){
                int id_c=obtener_Id_Cliente(clie);
                for(Servicio serv_cliente: clie.getSer()){
                if(serv_cliente.getTipo_servicio().equalsIgnoreCase("aplicacion")){
                    int id_t_servicio=2;
                    if(asociar_Servicio_Cliente(id_t_servicio,id_c)){
                    System.out.println("Se asocio correctamente el servicio al cliente ingresado");
                    break;
                    }else{
                    System.out.println("El servicio no sé asocio correctamente al cliente que se acaba de dar de alta");
                    break;
                    }
                }else if(serv_cliente.getTipo_servicio().equalsIgnoreCase("operativo")){
                    int id_t_servicio=4;
                    if(asociar_Servicio_Cliente(id_t_servicio,id_c)){
                    System.out.println("Se asocio correctamente el servicio al cliente ingresado");
                    break;
                   }else{
                    System.out.println("El servicio no sé asocio correctamente al cliente que se acaba de dar de alta");
                    break;
                    }
                }else{
                   System.out.println("El servicio que intenta asociar al cliente, es un servicio que no sé encuentra en nuestros registros");
                      }
                }
            }else{
                System.out.println("No sé pudo obtener el id del cliente...");
            }
            }else{
            System.out.println("No sé ingreso/aron el/los cliente/s al sistema");
        }
    }
  }
   
    public ArrayList<Servicio> cargar_Servicio_Cliente(int cantidad_serv){
        Scanner ingreso=new Scanner(System.in);
        ArrayList<Servicio>ser=new ArrayList();
        for(int i=0;i<cantidad_serv;i++){
                Servicio s=new Servicio();
                System.out.println("ingrese el nombre del tipo de servicio que quiere asociar al cliente");
//                String tipo_s=ingreso.next();
                s.setTipo_servicio(ingreso.next());
                System.out.println("ingrese el nombre del software por el cual se le va a brindar el servicio de soporte");
//                 String nombre_soft=ingreso.next();
                s.setNombre_software(ingreso.next());
                s.setId_empresa(1);
                ser.add(s);
        }       
        return ser;
    }

    @Override
    public boolean Alta_Incidente(Incidente i) {
        return false;
    }

    @Override
    public boolean verificar_S(Servicio s) {
        return false;
    }

    @Override
    public boolean insertar_Servicio_Bd(Servicio s) {
        return false;
    }

    @Override
    public boolean asociar_Servicio_Cliente(int id_servicio, int id_cliente) {
        Connection connec=null; 
        PreparedStatement pres=null;
        ResultSet rs=null;
     
        try{
               
               connec= Conex_Bd.devolver_Conexion();
               
               String sent_sql= "insert into servicio_cliente (id_servicio, id_cliente) ";
                      sent_sql += "values (?,?) ";  
                pres=connec.prepareStatement(sent_sql);
                pres.setInt(1, id_servicio);
                pres.setInt(2, id_cliente);
                pres.execute();
                 return true;                    
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
    public boolean verificar_C(Cliente c) {
        Connection connec=null; 
        PreparedStatement pres=null;
        ResultSet rs=null;
     
        try{
               
               connec= Conex_Bd.devolver_Conexion();
               
               String sent_sql= "SELECT COUNT(*) FROM Cliente WHERE cuit = ?";
                
                pres=connec.prepareStatement(sent_sql);
                pres.setLong(1, c.getCuit());
                rs=pres.executeQuery();
                if(rs.next()){
                   if(rs.getInt(1)>0){
                       System.out.println("el cliente ya se encuentra registrado");
                       return false;
                   }else{ 
                       if(connec.isClosed()){
                        connec=Conex_Bd.devolver_Conexion();
                       }
                        insertar_Registro_Cliente_Bd(c);
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
    public boolean insertar_Registro_Cliente_Bd(Cliente clien) {
         Connection connec=null; 
         PreparedStatement pres=null;
     
     try{
     
         connec= Conex_Bd.devolver_Conexion();
         String sent_sql= "insert into cliente(desc_razon_social,cuit,id_area_comercial)";
                sent_sql += "values (?,?,?)";
     
                pres=connec.prepareStatement(sent_sql);
                pres.setString(1, clien.getDescripcion_razon_social());
                pres.setLong(2, clien.getCuit());
                pres.setInt(3, clien.getId_area_com());
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
						}
	catch(Exception ex)
		{
		JOptionPane.showMessageDialog(null, "se genero un error y nose pudo cerrar la conexion" + ex);
					}
    }
    }

    @Override
    public int obtener_Id_Cliente(Cliente c) {
         int id=0;
         Connection connec=null; 
         PreparedStatement pres=null;
         ResultSet rs= null;
         
     try{
     
         connec= Conex_Bd.devolver_Conexion();
         String sent_sql= "select id_cliente from cliente where cuit= ?";
                
     
                pres=connec.prepareStatement(sent_sql);
                pres.setLong(1, c.getCuit());
                rs=pres.executeQuery();
                if(rs.next()){
                    if(rs.getInt(1)>0){
                        id=rs.getInt(1);                   
                        return id;
                    }
                }else{
                    System.out.println("No sé encontro ningun registro");
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
        return id;
    }
} 
    

