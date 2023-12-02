
package tp_final_java_inter;

import java.util.Scanner;

/**
 *
 * @author diego vargas
 */
/*Desde la clase Ejecutora, accedemos al menu principal del sistema de reportes de incidentes y comenzamos a correr nuestro programa**/
public class Ejecutadora_Tp_Final_App {

   
    public static void main(String[] args) {
       Scanner ingreso_datos=new Scanner(System.in);
        
        int opcion=0;
        do{
            menu_Opciones();
            System.out.println("\n A continuación seleccione una opcion válida...");
            opcion=ingreso_datos.nextInt();
            ingreso_datos.nextLine();
            
            switch(opcion){
            
                case 1:
                        Empresa_Servicio emp=new Empresa_Servicio();
                        emp.ingresar_Servicio();
                    break;
                case 2:
                        Area_Comercial ac=new Area_Comercial();
                        ac.ingresar_Cliente();
                    break;
            
                case 3:
                   
                    break;    
                case 4:
                   
                    break;  
                case 5:
                   
                    break;  
                case 6:
                   
                    break;  
                case 0:
                    salir_Sistema();
                    break;    
                default:
                    System.out.println("Lo siento, debe seleccionar una opcion válida (0 a 3)");
            }
        
            }while(opcion!=0);
    
    }
    public static void menu_Opciones(){
        System.out.println("\n Bienvenidos al sistema que permite reportar incidentes tipo Software");
        System.out.println("***************************************************************************************************************");
        System.out.println("\n 1- Ingresar nuevos Servicios'");
        System.out.println("\n 2- Ingresar nuevos Clientes");
        System.out.println("\n 3- Ingresar nuevos Tecnicos'");
        System.out.println("\n 4- Asignar especialidad/es a un tecnico");
        System.out.println("\n 5- Reportar incidente");
        System.out.println("\n 6- Ingresar/Asociar problema a un incidente");
       
    }
    
    public static void salir_Sistema(){
        System.out.println("\n saliendo del sistema, hasta pronto!!!");
        System.exit(0);
    }
    }
    

