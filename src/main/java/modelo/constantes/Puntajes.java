package modelo.constantes;

import java.io.Serializable;

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

    private static String puesto1 = "";
    private static String puesto2 = "";
    private static String puesto3 = "";

    public static final int menorEdad1 = 0;
    public static final int menorEdad2 = 1;
    public static final int mayorEdad2 = 2;

    private static int edad1 = -1;
    private static int edad2 = -1;

    public static final int PRIMARIO = 0;
    public static final int SECUNDARIO = 1;
    public static final int TERCIARIO = 2;

    public static String[][] NOMBRES_FORM_BUSQUEDA = {{"Media","Completa","Extendida"},
                                                      {puesto1,puesto2,puesto3},
                                                      {"edad menor a " + Puntajes.getEdad1()," entre " + Puntajes.getEdad1() + " y " + edad2, "edad mayor a " + Puntajes.getEdad2()},
                                                      {"sin experiencia","experiencia media","mucha experiencia"},
                                                      {"primerio","secundario","terciario"}};

    public static void setEdad1(int edad) {
        edad1 = edad;
        Puntajes.NOMBRES_FORM_BUSQUEDA[2][1] = "entre " + edad1 + " y " + edad2;
        Puntajes.NOMBRES_FORM_BUSQUEDA[2][0] = "edad menor a " + edad1;
    }

    public static void setEdad2(int edad) {
        edad2 = edad;
        Puntajes.NOMBRES_FORM_BUSQUEDA[2][1] = "entre " + edad1 + " y " + edad2;
        Puntajes.NOMBRES_FORM_BUSQUEDA[2][2] = "edad mayor a " + edad2;
    }

    public static int getEdad1() {
        return edad1;
    }

    public static int getEdad2() {
        return edad2;
    }

    public static String getPuesto1() {
        return puesto1;
    }

    public static String getPuesto2() {
        return puesto2;
    }

    public static String getPuesto3() {
        return puesto3;
    }

    public static void setPuesto1(String puesto1) {
        Puntajes.puesto1 = puesto1;
        Puntajes.NOMBRES_FORM_BUSQUEDA[1][0] = puesto1;
    }

    public static void setPuesto2(String puesto2) {
        Puntajes.puesto2 = puesto2;
        Puntajes.NOMBRES_FORM_BUSQUEDA[1][1] = puesto2;
    }

    public static void setPuesto3(String puesto3) {
        Puntajes.puesto3 = puesto3;
        Puntajes.NOMBRES_FORM_BUSQUEDA[1][2] = puesto3;
    }
}
