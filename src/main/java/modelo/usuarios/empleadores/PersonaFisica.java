package modelo.usuarios.empleadores;

import java.io.Serializable;

public class PersonaFisica extends Empleador implements Serializable {

    public PersonaFisica(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
    }

    public PersonaFisica(String nombreUsuario, String contrasena, String tipoPersona, String razonSocial, String rubro) {
        super(nombreUsuario, contrasena, tipoPersona, razonSocial, rubro);
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
}
