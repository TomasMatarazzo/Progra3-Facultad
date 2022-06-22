package modelo.usuarios.empleadores;

import java.io.Serializable;

public class PersonaFisica extends Empleador {

    public PersonaFisica(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
    }

    public PersonaFisica(String nombreUsuario, String contrasena, String razonSocial, String rubro) {
        super(nombreUsuario, contrasena, razonSocial, rubro);
    }



	@Override
	public double calculaComision(double remuneracion) {
        double porcentaje;

        porcentaje = calculaPorcentajeComision();
        //Por cada punto obtenido se le resta un 1% al valor de la comisión
        if (this.puntaje > 0)
            porcentaje -= 0 + (0.01 * this.puntaje);

        return remuneracion * porcentaje;
    }
    public String getTipo() {
    	return "Persona Fisica";
    }
}
    

