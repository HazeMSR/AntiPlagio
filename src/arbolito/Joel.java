import java.util.Scanner;
  
class CompareStrings
{
   public static void main(String args[])
   {
      String s1, s2;
      Scanner in = new Scanner(System.in);
  
      System.out.println("ingresa la primera línea ");
      s1 = in.nextLine();
  
      System.out.println("ingrese la segunda linea");
      s2 = in.nextLine();
  
      if ( s1.compareTo(s2) > 0 )
         System.out.println("la primera línea es mayor a la 2.");
      else if ( s1.compareTo(s2) < 0 )
         System.out.println("la primera línea es menor a la segunda.");
      else  
         System.out.println(" ambas son iguales .");
   }
}