
package tp_final_java_inter;

import java.util.ArrayList;
import lombok.Data;

/**
 *
 * @author diego vargas
 */
/*Hacemos uso de la libreria lombok para facilitar el desarrollo del codigo,ya que, con la declaracion que acabamos de hacer,
no nos debemos preocupar por los setter y getter, toString y demas.... metodos del objeto en cuestion, lo resuelve la libreria lombok**/
@Data
public class Cliente {
    private String nombre;
    private String descripcion_razon_social;
    private long cuit;
    private ArrayList<Servicio> ser;
    private int id_area_com;

   
    
    public Cliente(){};

}
