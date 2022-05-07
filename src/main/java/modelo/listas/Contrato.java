package modelo.listas;

import modelo.usuarios.Empleado_Pretenso;
import modelo.usuarios.empleadores.Empleador;

public class Contrato {
    private Empleador empleador;
    private Empleado_Pretenso empleado_pretenso;
    private double remuneracion;

    public Contrato(Empleador empleador, Empleado_Pretenso empleado_pretenso, double remuneracion) {
        this.empleador = empleador;
        this.empleado_pretenso = empleado_pretenso;
        this.remuneracion = remuneracion;
    }

    //GETTERS
    public Empleador getEmpleador() {
        return empleador;
    }

    public Empleado_Pretenso getEmpleado_pretenso() {
        return empleado_pretenso;
    }

    public double getRemuneracion() {
        return remuneracion;
    }
}
