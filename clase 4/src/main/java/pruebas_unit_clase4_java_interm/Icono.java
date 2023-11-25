
package pruebas_unit_clase4_java_interm;

/**
 *
 * @author diego vargas
 */
public class Icono {
    public static Icono nota_musical= new Icono(new int[]{0xD83C, 0xDFB5});
    public static Icono ROCKET = new Icono(new int[]{0xD83D, 0xDE80});
    public static Icono FIRE = new Icono(new int[]{0xD83D, 0xDD25}); 
    private int[] internalEncoding;
   
    public Icono(){};
    public Icono(int[] internalEncoding) {
        this.internalEncoding=internalEncoding;
    }
/*Creamos el metodo toString para mostrar la informacion del objeto y asi evitamos mostrar la direccion de memoria del mismo**/
    /*cuando llamamos a los atributos(static) de la clase**/
    @Override
    public String toString() {
        return "Icono{"    + transformando_Unicode_Texto()+'}';
    }
    /*el siguiente método transforma el codigo unicode(compuesta por enteros) de cada atributo static a un String**/
    public String transformando_Unicode_Texto(){
        return new String(internalEncoding, 0, internalEncoding.length);
    }
}
