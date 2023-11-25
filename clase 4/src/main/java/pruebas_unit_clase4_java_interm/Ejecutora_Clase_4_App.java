
package pruebas_unit_clase4_java_interm;


/**
 *
 * @author diego vargas
 */
public class Ejecutora_Clase_4_App {

   
    public static void main(String[] args) {
       
        /*Creamos una instancia de la clase Cancion, para poder hacer uso de sus respectivos metótodos**/
        Cancion cancion= new Cancion();
        cancion.reproducir_Cancion();
        /*La cancion reproducida anteriormente,al menos va a tener una popularidad normal, ya que tiene una reproducción**/
        cancion.mostrar_Popularidad_Cancion();


    }
}
    
    
