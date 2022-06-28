package persistencia;

import java.io.Serializable;

public class PuntajesDTO implements Serializable {
    private int edad1;
    private int edad2;
    private String puesto1;
    private String puesto2;
    private String puesto3;

    public int getEdad1() {
        return edad1;
    }

    public void setEdad1(int edad1) {
        this.edad1 = edad1;
    }

    public int getEdad2() {
        return edad2;
    }

    public void setEdad2(int edad2) {
        this.edad2 = edad2;
    }

    public String getPuesto1() {
        return puesto1;
    }

    public void setPuesto1(String puesto1) {
        this.puesto1 = puesto1;
    }

    public String getPuesto2() {
        return puesto2;
    }

    public void setPuesto2(String puesto2) {
        this.puesto2 = puesto2;
    }

    public String getPuesto3() {
        return puesto3;
    }

    public void setPuesto3(String puesto3) {
        this.puesto3 = puesto3;
    }

    @Override
    public String toString() {
        return "PuntajesDTO{" +
                "edad1=" + edad1 +
                ", edad2=" + edad2 +
                ", puesto1='" + puesto1 + '\'' +
                ", puesto2='" + puesto2 + '\'' +
                ", puesto3='" + puesto3 + '\'' +
                '}';
    }
}
