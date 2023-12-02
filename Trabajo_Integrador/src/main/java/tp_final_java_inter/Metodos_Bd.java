
package tp_final_java_inter;

/**
 *
 * @author diego vargas
 */
/**creamos la siguiente interface, basandonos en la solucion que nos brinda el patron de diseño strategy,para que cada uno de todos
 los metodos incluidos en la misma, se adapten de acuerdo al contexto y nos permitan operar de diferentes maneras con la bd**/
public interface Metodos_Bd {
    
    public boolean Alta_Incidente(Incidente i);
    public boolean verificar_S(Servicio s);
    public boolean insertar_Servicio_Bd(Servicio s);
    public int obtener_Id_Cliente(Cliente c);
    public boolean asociar_Servicio_Cliente(int id_servicio, int id_cliente);
    public boolean verificar_C(Cliente c);
    public boolean insertar_Registro_Cliente_Bd(Cliente clien);
}
