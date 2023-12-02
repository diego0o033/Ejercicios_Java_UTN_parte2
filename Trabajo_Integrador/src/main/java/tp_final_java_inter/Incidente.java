
package tp_final_java_inter;

import java.sql.Date;

/**
 *
 * @author diego vargas
 */
public class Incidente {
 
  private int id_incidente;
  private String desc_incidente;
  private Date fecha_ingreso;
  private int colchon_hs_estimadas;
  private String estado;
  private Date fecha_resol_estimada;
  private Cliente clien;
  private Tecnico tecnico;
  private Operador operador;
  private Problema problema;
public Incidente(){}

public boolean ingresar_Incidente(Cliente c,Tecnico t, Operador o,Problema p,String descrip){

return true;
}
public Tecnico asignar_Tecnico(Tecnico t){

return t;
}
public boolean confirmar_Incidente(){

return true;
}
public String resolver_Incidente(String considera){

return considera;
}
public void agregar_Horas(int hs){}

}
