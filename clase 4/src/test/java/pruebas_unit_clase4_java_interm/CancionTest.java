
package pruebas_unit_clase4_java_interm;

import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author diego vargas
 */
public class CancionTest {
    
    public CancionTest() {
    }
    
    /*En cada test se pasan valores necesarios al objeto canción, para poder realizar la correcta prueba unitaria en cada caso**/
    @Test
    public void testPopularidad_Normal() {
        /* en este test no pasamos valores al crear el objeto cancion, ya que, con  una sola reproduccion que la obtenemos del metodo**/
        /* reproducir_Cancion() es suficiente, para realizar la prueba**/
        Cancion cancion = new Cancion();
        cancion.reproducir_Cancion();
        System.out.println("La siguiente cancion:" + " " + "The Scientist (canción), Coldplay (artista), A Rush of Blood to the head (Álbum),\n "
                + " 2002 (año del álbum y de la canción)");
        cancion.mostrar_Popularidad_Cancion();
    }

    @Test
    public void testPopularidad_Auge() {     
        /*Colocamos los valores necesarios al crear el objeto cancion, para realizar la prueba**/
        Icono icono=new Icono();
        Cancion cancion = new Cancion(4000,2000,100,LocalDateTime.now(),icono);  
        System.out.println("La siguiente cancion:" + " " + "The Scientist (canción), Coldplay (artista), A Rush of Blood to the head (Álbum),\n "
                + " 2002 (año del álbum y de la canción)");
        cancion.mostrar_Popularidad_Cancion();
       
    }
    @Test
    public void testBaja_Popularidad_Auge_Normal() {     
        /*Colocamos los valores necesarios al crear el objeto cancion, para realizar la prueba**/
        Icono icono=new Icono();
        Cancion cancion = new Cancion(4000,2000,5005,LocalDateTime.now(),icono);  
        System.out.println("La siguiente cancion:" + " " + "The Scientist (canción), Coldplay (artista), A Rush of Blood to the head (Álbum),\n "
                + " 2002 (año del álbum y de la canción) " + " " + " perdío la popularidad de auge a normal, debido\n"
                + " a que tiene mas de cinco mil dislikes...");
        cancion.mostrar_Popularidad_Cancion();
    }
    
    @Test
    public void testBajaPopularidad_Tendencia() {
        /*Colocamos los valores necesarios al crear el objeto cancion, para realizar la prueba**/
        /*para este caso en particular, generamos nuevas variables para **/
        int dia=28;
        int mes=3;
        int año=2023;
        int hora=21;
        int minutos=30;
        Icono icono=new Icono();
        Cancion cancion = new Cancion(62000,25000,500,LocalDateTime.of(año,mes, dia, hora, minutos),icono);  
        System.out.println("La siguiente cancion:" + " " + "The Scientist (canción), Coldplay (artista), A Rush of Blood to the head (Álbum),\n "
                + " 2002 (año del álbum y de la canción)" + " " + "perdio la popularidad de tendencia y paso a tener una popularidad\n"
                + "normal,debido a que no se ha reproducido durante las siguientes 24 horas...");
        cancion.mostrar_Popularidad_Cancion();
    }
    
    @Test
    public void testPopularidad_Tendencia() {
        /*Colocamos los valores necesarios al crear el objeto cancion, para realizar la prueba**/
        Icono icono=new Icono();
        Cancion cancion = new Cancion(62000,25000,500,LocalDateTime.now(),icono);  
        System.out.println("La siguiente cancion:" + " " + "The Scientist (canción), Coldplay (artista), A Rush of Blood to the head (Álbum),\n "
                + " 2002 (año del álbum y de la canción)");
        cancion.mostrar_Popularidad_Cancion();
    }
    
}
