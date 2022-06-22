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
    public double calculaPorcentajeComision() {
        if (this.getRubro().equalsIgnoreCase("SALUD"))
            return  0.60;
        else if (this.getRubro().equalsIgnoreCase("COMERCIO LOCAL"))
            return  0.70;
        else //Es rubro COMERCIO INTERNACIONAL
            return  0.80;
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
}
    

