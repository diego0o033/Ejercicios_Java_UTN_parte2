
package pruebas_unit_clase4_java_interm;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author diego vargas
 */
public class Cancion implements Popularidad_Cancion {

    private int cantidad_reproducciones=0;
    private int cantidad_likes=0;
    private int cantidad_dislikes=0;        
    private LocalDateTime ultima_reprod_cancion=null;
    private Icono icono;
    
    public Cancion(){};
    
    public Cancion(int reproducciones, int likes, int dislikes, LocalDateTime ultima_reprod,Icono icono){
        this.cantidad_reproducciones=reproducciones;
        this.cantidad_likes=likes;
        this.cantidad_dislikes=dislikes;
        this.ultima_reprod_cancion=ultima_reprod;
        this.icono=icono;
    }   
    /*Generamos un método que nos va a permitir contabilizar las reproducciones de la  cancion y a su vez,registrar el tiempo en que 
     se realizo la última reproducción**/
    public void reproducir_Cancion(){
        cantidad_reproducciones += 1;
        ultima_reprod_cancion=LocalDateTime.now();
        System.out.println("se esta reproduciendo la cancion seleccionada....");
        
    }
    
    /*Con este método verificamos la ultima vez que se reproducio la cancion y tambien evaluamos si la cancion se ha sido
    reproducida durante las siguientes 24 hs**/
   public  boolean verificar_Ultima_Reprod(){
    
        if(ultima_reprod_cancion==null){
            System.out.println("lo siento, la cancion no ha sido reproducida...");
            return false;
        }else{
            LocalDateTime reproduccion_ahora= LocalDateTime.now();
            /*Realizamos la comparación de la ultima reproduccion con la reproduccion actual y verificamos en horas
            si no ha pasado mas de 24 horas de la ultima reproduccion**/
            long hora_ult_reprod= ChronoUnit.HOURS.between(ultima_reprod_cancion, reproduccion_ahora);
            if(hora_ult_reprod<=24){
                System.out.println(" la cancion se ha reproducido dentro del rango de 24 horas...");
                return true;
            }else{
                System.out.println("lo siento, la cancion no se ha reproducido dentro de las 24 horas...");
                return false;
            }
        }
       
   }
    
    public void hacer_Like(){
        cantidad_likes+=1;
    }
    public void hacer_Dislike(){
        cantidad_dislikes+=1;
    }
    /*Mostramos la popularidad de la cancion,siempre y cuando se cumplan una serie de requisitos**/
    public void mostrar_Popularidad_Cancion(){
            
            if(cantidad_reproducciones <0){
                System.out.println("lo siento,la canción aún no se ha reproducido...por lo tanto no tiene popularidad");
            }else if(cantidad_reproducciones >0  && cantidad_reproducciones <=1000){
                    this.popularidad_Normal();
            } else if((cantidad_reproducciones >1000 && cantidad_reproducciones<50000) && (cantidad_likes < 20000) && (cantidad_dislikes<5000)){
                this.popularidad_Auge();
            }else if((cantidad_reproducciones>50000) && (cantidad_likes > 20000) && (cantidad_dislikes<5000) && (verificar_Ultima_Reprod()==true)){
            this.popularidad_Tendencia();   
            }else {
                    this.popularidad_Normal();
            }
    }
    
    @Override
    /*si la cancion cumple con determinados requisitos,llamamos al metodo de popularidad correspondiente y mostramos un icono con su 
    respectivo mensaje**/
    public void popularidad_Normal() {
       /*en todos los casos,cuando quiero mostrar el icono, me aparece un signo de interrogación...desconozco el motivo**/
        System.out.println(Icono.nota_musical + " " + " nombre artista: Coldplay " + " " + "Album: A Rush of Blood to the head " + " " + "nombre de la cancion: Scientist" + " " );
        System.out.println(" la popularidad de la cancion es normal... " );
    }

    @Override
    public void popularidad_Auge() {
        System.out.println(Icono.ROCKET + " " + " nombre artista: Coldplay " + " " + " Album: A Rush of Blood to the head " + " " + " nombre de la cancion: Scientist ");
        System.out.println(" la popularidad de la cancion se encuentra en auge... " );
    }

    @Override
    public void popularidad_Tendencia() {
         System.out.println(Icono.FIRE + " " + " nombre artista: Coldplay " + " " + " Album: A Rush of Blood to the head " + " " + " nombre de la cancion: Scientist ");
         System.out.println(" la popularidad de la cancion se encuentra en tendencia!!!... " );
    }
    
}
