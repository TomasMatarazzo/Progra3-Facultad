package util;
import java.util.Random;

public abstract class Util
{
    public static final Random r = new Random();

    public static void espera(int milisegundos)
    {
	try
	{
	    Thread.sleep(milisegundos);
	} catch (InterruptedException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public static void espera()
    {
	Util.espera(r.nextInt(300));
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