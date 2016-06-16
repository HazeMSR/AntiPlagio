/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolito;

import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 * @author la gfa del Beto
 */

 public class archivo{
    File f;
    FileReader lectorArchivo;   
    //Filewriter escritorArchivo;    
    public void concatenar(String lr, String txt){
        String tm= this.leer(lr);
        tm=tm+txt;
    //    this.creartxt(lr, tm);
    }    
   /* public void creartxt(String lr, String txt){
        try{        
            f=new File(lr);
            escritorArchivo=new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(escritorArchivo);
            PrintWriter salida= new PrintWriter(bw);          
            salida.Writer(txt+"ln");          
            salida.close();                  
        }catch(IOException e){
                System.out.println("Error: "+e.getMessage());
                }
    }
    */   
    public String leer(String lr){
      File f;
      FileReader lectorArchivo; 
      try{
          f=new File(lr);
          lectorArchivo = new FileReader(f);
         BufferedReader br = new BufferedReader( new InputStreamReader(new FileInputStream(lr), "ISO-8859-1"));
          String cad="";
          String aux="";     
          while(true){
              aux=br.readLine();
              if(aux!=null){
                  cad=cad+aux+"\n";
              }
              else{
                  break;
              }    
          }
            br.close();
            lectorArchivo.close();
            return cad;
          
          }catch(IOException e){
              System.out.printf("Error: "+e.getMessage());
          }
        return null;
  }
  
/*public String leerGrafico()
{
    File f;
    javax.swing.JFileChooser j= new javax.swing.JFileChooser();
    j.showOpenDialog(j);
    String path= j.getSelectedFile().getAbsolutePath();
    String lectura="";
    f=new File(path);
        
    try{
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader (fr);
        String aux;
        while((aux=br.readLine())!=null);
            lectura=lectura+aux+"\n";

    } catch(IOException e){}
return lectura;
}
*/

    public ArrayList<String> separaArchivo(String direccion){      

      ArrayList<String> regreso = new ArrayList<String>();
     // String cad=a.leer("C:/Users/Master/Desktop/ESCOM/Prueba1.txt");      
      archivo a2=new archivo();      
      String cad2=a2.leer(direccion);
      String[] temp;
      String delimiter2 = "[-_. ,;:(){}=<>~\\n\\uFFFD\\u0021\\u00A1\\u003F\\u00BF\\u00B0\\u007C\\u0023\\u0025\\u0025\\u003D\\u002B\\u005E\\u00AC\\u00B6\\u23CE\\u0040\\002A\\u0022\\u0027\\u005C\\u2386\\u002F\\u005B\\u005D\\u00AB\\u00BB]+";
       temp = cad2.split(delimiter2);
      for(int i2 =0; i2 < temp.length ; i2++){
          //System.out.println(temp[i2]);
        regreso.add(temp[i2]);
      }
      return regreso;
    }
    public int longitudArchivo(String direccion){
      archivo a=new archivo();
      int regresa;
      String cad=a.leer(direccion);      
      regresa=cad.length();
      return regresa;
    }
    public String fechaArchivo(String direccion){
      String regresa;
      File file = new File(direccion);
      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
      regresa=sdf.format(file.lastModified());    
      return regresa;
    }
}