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

    public static final int menos40 = 0;
    public static final int menos50 = 1;
    public static final int mas50 = 2;

    public static final int PRIMARIO = 0;
    public static final int SECUNDARIO = 1;
    public static final int TERCIARIO = 2;
}
