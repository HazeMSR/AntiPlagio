
package arbolito;
import java.util.*;

public class Arbolito{
    public class Nodo{
        int idP;
        int id;
        String parrafo;
        Nodo padrazo;
        Nodo sig;
        boolean comparacion;
        ArrayList<String> homologos;
        ArrayList<Nodo> hijos;
        ArrayList<Character> caracter;

    }
    Nodo inicial;
    Nodo actual;
    Nodo aux;
    int cant;
    int altura;
    int cuenta=1;
    int cuenta2=1;
    


    public Arbolito() {
        inicial=null;
    }
    public void contar(){
        cuenta++;
    }
    public void contarx2(){
        actual=inicial;
        while(actual!=null){
            actual=actual.sig;
            cuenta2++;
        }   
    }
    // La primera vez padre serÃ¡ inicial y el id == 1 j==0
    public void recorre(int busca,Nodo padre){
        actual=padre;
        int valida=0;
        if(actual.id != busca) {
            if(actual.id==1 && (actual.hijos.isEmpty() || actual.hijos == null))
                    System.out.println("\nNo existe el nodo ingresado.");
            else{
                if(actual.hijos.isEmpty() || actual.hijos == null){
                    if((actual.padrazo.hijos.indexOf(actual)) < (actual.padrazo.hijos.size()- 1))
                        if(actual.padrazo.hijos!=null)
                        recorre(busca,actual.padrazo.hijos.get((actual.padrazo.hijos.indexOf(actual))+1 ));
                    else
                         System.out.println("\nSe recorriÃ³ toda la lista");
                }
                else{
                    if(actual.hijos!=null)
                    recorre(busca,actual.hijos.get(0));
                }
            }
	}
    }
    public Nodo recorreuno(Nodo uno){
        Nodo re;
        if(uno.sig!=null)
            re=uno.sig;
        else
            re=null;
        return re;
    }

    public void agregarCaracter(Nodo padre,String texto){
        int i;
        for(i=0;i<texto.length();i++){
            padre.caracter.add(texto.charAt(i));
        }
    }
    public boolean esSinonimo(Nodo lista,String palabra){
        boolean regreso=false;
        int i;
        String aux;
        if(lista.homologos!=null)
        for(i=0;i<lista.homologos.size();i++){
            aux=lista.homologos.get(i);
            if(aux.matches(palabra))
                regreso=true;
        }       
        return regreso;
    }
    public void insertar(String info,boolean ver){
        request2 re = new request2();
    if(inicial==null){
        actual=new Nodo();
        actual.parrafo=info;
        actual.sig=null;
        actual.idP=0;
        actual.id=cuenta;
        actual.hijos= new ArrayList<Nodo>();
        actual.caracter= new ArrayList<Character>();
        actual.homologos = re.sinonimos(info,ver);
        actual.comparacion = false;
        agregarCaracter(actual,info);
        //agregarAnidado(actual," quiubox2");
        inicial=actual;
        contar();
    }
    else{
        aux= new Nodo();
        aux.parrafo=info;
        aux.sig=null;
        aux.idP=actual.id;
        aux.id=cuenta;
        aux.hijos= new ArrayList<Nodo>();
        aux.caracter= new ArrayList<Character>();
        aux.comparacion = false;
        aux.homologos = re.sinonimos(info,ver);
        agregarCaracter(aux,info);
        //agregarAnidado(aux," quiubox2");
        actual.sig=aux;
        actual=aux;
        contar();
    }
}
  public void mostrarTodos(){
  actual=inicial;
  int valida=1,i=1;
  System.out.println("  Id:  | Id del Padre: | Texto:");
  System.out.println("-------------------------------\n");
  while(actual!=null){
    System.out.println("  "+actual.id+"  |  "+actual.idP+"  |  "+actual.parrafo);
    actual=actual.sig;
    i++;
  }
}
    public void muestra(int busca,Nodo padre){
        actual=padre;
        int valida=0;
        if(actual.id != busca) {
            if(true){
                if(actual.id==1 && (actual.hijos.isEmpty() || actual.hijos == null))
                        System.out.println("\nNo existe el nodo ingresado.");
                else{
                    if(actual.hijos.isEmpty() || actual.hijos == null){
                        if((actual.padrazo.hijos.indexOf(actual)) < (actual.padrazo.hijos.size()- 1)){
                            if(actual.padrazo.hijos!=null)
                                muestra(busca,actual.padrazo.hijos.get((actual.padrazo.hijos.indexOf(actual))+1 ));
                        }   
                        /*else
                            System.out.println("\nSe recorriÃ³ toda la lista");*/
                    }
                    else{
                        if(actual.hijos!=null)
                        muestra(busca,actual.hijos.get(0));
                    }
                }                
            }

	}
        else
            System.out.println("  "+actual.id+"  |  "+actual.idP+"  |  "+actual.parrafo);
    }
    public void muestraTodo(){
        System.out.println("  Id:  | Id del Padre: | Texto:");
        for(int i=0; i<cuenta ;i++)
            muestra(i,inicial);
        
    }
    public void muestraSinonimos(Nodo algun){
        System.out.println(" Id:  | Sinonimo: ");
        for(int i=0; i<algun.homologos.size() ;i++)
            System.out.println(" "+i+" "+algun.homologos.get(i));   
    }
    public void compara(Nodo uno, Nodo dos){
        if(uno.parrafo.matches(dos.parrafo)){
            uno.comparacion=true;
        }
        if(esSinonimo(uno,dos.parrafo)){
            uno.comparacion=true;
        }
    }
    /*public static void main (String [] ar){
        Arbolito abo = new Arbolito ();
        abo.insertar("amor");
        abo.muestraSinonimos(abo.actual);
        System.out.println("Es sinonimo: "+abo.esSinonimo(abo.actual,"afecto"));
        abo.insertar(" mundo");
        abo.insertar(" mun");
        abo.insertar(" favorite");
        System.out.println("El id actual es: "+abo.actual.id);
        System.out.println("El id del padre actual es: "+abo.actual.idP);

        abo.insertar(" quiubo");
        System.out.println("El id actual es: "+abo.actual.id);
        System.out.println("El id del padre actual es: "+abo.actual.idP);
        abo.mostrarTodos();
    }*/      
}