package modelo.constantes;

public class Puntajes {
    public static double[][] RENUMERACION = {{1,-0.5,-1},
            {1,1,-0.5},
            {1,1,1}};

    // se usara  para CARGA HORARIA , TIPO DE TRABAJO, RANGO ETARIO
    public static double[][] MATRIZ2 = {{1,-0.5,-1},
            {-0.5,1,-0.5},
            {-1,1,-0.5}};

    // se usara para  EXPERIENCIA PREVIA, ESTUDIOS CURSADOS
    public static double[][] MATRIZ3 = {{1,1.5,2},
            {-0.5,1,1.5},
            {-2,-1.5,1}};

    public static final int V1 = 20000;
    public static final int V2 = 40000;

    public static final int MEDIA = 0;
    public static final int COMPLETA = 1;
    public static final int EXTENDIDA = 2;

    public static final int JR = 0;
    public static final int SENIOR = 1;
    public static final int MANAGMENT = 2;

    public static String puesto1;
    public static String puesto2;
    public static String puesto3;


    public static final int menorEdad1 = 0;
    public static final int menorEdad2 = 1;
    public static final int mayorEdad2 = 2;
    public static int edad1 ;
    public static int edad2 ;

    public static final int PRIMARIO = 0;
    public static final int SECUNDARIO = 1;
    public static final int TERCIARIO = 2;

    public static final String[][] NOMBRES_FORM_BUSQUEDA = {{"Media","Completa","Extendida"},
                                                            {puesto1,puesto2,puesto3},
                                                            {"edad menor a " + edad1, "entre" + edad1 + "y" + edad2,"edad mayor a " + edad2},
                                                            {"sin experiencia","experiencia media", "mucha experiencia"},
                                                            {"primerio","secundario","terciario"}};

    public static void setEdad1(int edad){
        edad1 = edad;
    }

    public static void setEdad2(int edad){
        edad2 = edad;
    }

    public static void setPuesto1(String puesto1) {
        Puntajes.puesto1 = puesto1;
    }

    public static void setPuesto2(String puesto2) {
        Puntajes.puesto2 = puesto2;
    }

    public static void setPuesto3(String puesto3) {
        Puntajes.puesto3 = puesto3;
    }
}
