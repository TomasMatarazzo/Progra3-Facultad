package util;

import java.util.Random;

public abstract class UtilSimulacion
{
    public static final Random r = new Random();

    public static void espera(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {

        }
    }
    
	public static boolean esNumero(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
}