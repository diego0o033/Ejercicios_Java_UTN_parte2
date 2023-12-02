
package tp_final_java_inter;

import lombok.Getter;



/**
 *
 * @author diego vargas
 */
@Getter
public class Operador implements Metodos_Bd{
 private int id_operador;
 private String nombre;
 

public Operador(){}

    
public boolean agregar_Horas_Extras_Inci(Incidente i,int hs){

return true;
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

    @Override
    public boolean asociar_Servicio_Cliente(int id_servicio, int id_cliente) {
        return false;
    }

}
