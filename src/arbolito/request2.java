

package arbolito;

import java.util.*; 
import java.io.*; 
import java.net.HttpURLConnection; 
import java.net.URL; 
import java.net.URLEncoder; 
import org.json.simple.*;

public class request2 {
   public boolean esAlfa(String s){
    String pattern= "^[a-zA-ZáéíóúÁÉÍÓÚñÑ]*$";
        if(s.matches(pattern)){
            return true;
        }
        return false;   
    }
   public boolean esAlfaN(String s){
    String pattern= "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ]*$";
        if(s.matches(pattern)){
            return true;
        }
        return false;   
    }
  public ArrayList<String> sinonimos(String solicitud, boolean ver){
    ArrayList<String> regreso = new ArrayList<String>();
    request2 re= new request2();
    String palabra="",aux="",aux2="";
    SendRequest enviar=new SendRequest(solicitud, "es_ES", "aNgI4J5pFOCLdISt6BQV", "json",ver);
    palabra=enviar.getRespuesta();
    int i,j=0;
    //System.out.println("palabra: "+palabra);
    if(enviar.fallo==false)
    for(i=0,j=0;i<palabra.length();i++){
        aux=palabra.substring(j,i);
        if(!re.esAlfa(aux)){
            regreso.add(palabra.substring(j,i-1));
            //System.out.println("aux: "+aux);
            j=i;
        }       
    }
    return regreso;
  } 
}

class SendRequest { 
  final String endpoint = "http://thesaurus.altervista.org/thesaurus/v1"; 

  String retorno;
  boolean fallo=false;
  public SendRequest(String word, String language, String key, String output,boolean ver2) { 
    try { 
      URL serverAddress = new URL(endpoint + "?word="+URLEncoder.encode(word, "UTF-8")+"&language="+language+"&key="+key+"&output="+output); 
      HttpURLConnection connection = (HttpURLConnection)serverAddress.openConnection(); 
      connection.connect(); 
      int rc = connection.getResponseCode(); 
      if (rc == 200) { 
        String line = null; 
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(connection.getInputStream())); 
        StringBuilder sb = new StringBuilder(); 
        while ((line = br.readLine()) != null) 
          sb.append(line + '\n'); 
        JSONObject obj = (JSONObject) JSONValue.parse(sb.toString()); 
        JSONArray array = (JSONArray)obj.get("response"); 
        for (int i=0; i < array.size(); i++) { 
          JSONObject list = (JSONObject) ((JSONObject)array.get(i)).get("list"); 
          retorno=list.get("synonyms").toString();
          if(ver2==true)
            System.out.println(retorno);
        }
        
      } else{
          String aux=String.valueOf(rc);
          if(ver2==true && aux.charAt(0)=='4'&& aux.charAt(1)=='0' && aux.charAt(2)=='4')
              System.out.println("No se encontro sinónimo para la palabra: "+word);
          //System.out.println("HTTP error:"+rc);
          fallo=true;
      }
      connection.disconnect(); 
    } catch (java.net.MalformedURLException e) { 
      e.printStackTrace(); 
    } catch (java.net.ProtocolException e) { 
      e.printStackTrace(); 
    } catch (java.io.IOException e) { 
      e.printStackTrace(); 
    } 
    //System.out.println(retorno);
  }
  String getRespuesta(){
      return retorno;
  }
}