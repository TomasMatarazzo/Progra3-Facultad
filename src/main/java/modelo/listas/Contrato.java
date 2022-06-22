package modelo.listas;

import modelo.usuarios.EmpleadoPretenso;
import modelo.usuarios.empleadores.Empleador;

import java.io.Serializable;

public class Contrato implements Serializable {
    private Empleador empleador;
    private EmpleadoPretenso empleado_pretenso;
    private double remuneracion;

    public Contrato(Empleador empleador, EmpleadoPretenso empleado_pretenso, double remuneracion) {
        this.empleador = empleador;
        this.empleado_pretenso = empleado_pretenso;
        this.remuneracion = remuneracion;
    }

    //GETTERS
    public Empleador getEmpleador() {
        return empleador;
    }

    public EmpleadoPretenso getEmpleado_pretenso() {
        return empleado_pretenso;
    }

    public double getRemuneracion() {
        return remuneracion;
    }
}
