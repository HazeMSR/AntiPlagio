/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolito;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Tablón
 */
public class analisis {

        Arbolito arbol1 = new Arbolito();
        Arbolito arbol2 = new Arbolito();
    
    public void Compara(){
       int i;
       String s1,s2,s3;
       boolean ver=false;
       boolean valida=false;
       ArrayList<String> nodo1 = new ArrayList<String>();
       ArrayList<String> nodo2 = new ArrayList<String>();
       Scanner in = new Scanner(System.in);
       System.out.println("Desea que se muestren los sinónimos de las palabras: (s/n) \n ");
       s3 = in.nextLine();
       System.out.println("Ingresa la direccion y el nombre del 1er archivo. Ejemplo: C:/Users/User/Desktop/archivo.txt\n ");
       s1 = in.nextLine();
       archivo ar= new archivo();
       nodo1=ar.separaArchivo(s1);
        if(s3.matches("s"))
            ver=true;
       for(i=0;i<nodo1.size();i++){
           arbol1.insertar(nodo1.get(i),ver);
       }

       System.out.println("Ingresa la direccion y el nombre del 2do archivo. Ejemplo: C:/Users/User/Desktop/archivo.txt\n ");
       s2 = in.nextLine();
       archivo ar2= new archivo();
       nodo2=ar2.separaArchivo(s2);
      
       Arbolito arbol2 = new Arbolito();
       
       for(i=0;i<nodo2.size();i++){
           arbol2.insertar(nodo2.get(i),ver);
       }
       
       for(i=0,arbol1.actual=arbol1.inicial, arbol2.actual=arbol2.inicial ;i<nodo1.size() && i<nodo2.size() && valida==false;i++){
           if(arbol1.actual!=null && arbol2.actual!=null){
               arbol1.compara(arbol1.actual,arbol2.actual);
               if(arbol1.actual.sig!=null && arbol2.actual.sig!=null){
                    arbol1.actual=arbol1.recorreuno(arbol1.actual);
                    arbol2.actual=arbol1.recorreuno(arbol2.actual);              
               }
               else
                   valida=true;
           }
       }
    }
    public double Cuenta(){
       int i,contador=0,booleanos=0;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       ;
       String s1,s2;
       boolean valida=false;
       ArrayList<String> nodo2 = new ArrayList<String>();
       if(arbol1.inicial==null && arbol2.inicial==null){
           Compara();
       }
       else{
           arbol1.actual=arbol1.inicial;
           while(arbol1.actual!=null){
               if(arbol1.actual.comparacion==true){
                   booleanos++;
               }
               contador++;
               arbol1.actual=arbol1.actual.sig;
           }
       }
       double regresa =(100*booleanos)/contador;
       return regresa;
    }
    public static void main(String[]args){
        System.out.println("hola");
        analisis anal = new analisis();
        anal.Compara();
        String aux = String.valueOf(anal.Cuenta());
        System.out.println("La probabilidad de plagio es de: "+aux+"%");
    }



}


