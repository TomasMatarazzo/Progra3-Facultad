package modelo.usuarios.empleadores;

import java.io.Serializable;

public class PersonaJuridica extends Empleador implements Serializable {

    public PersonaJuridica(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
    }

    public PersonaJuridica(String nombreUsuario, String contrasena, String tipoPersona, String razonSocial, String rubro) {
        super(nombreUsuario, contrasena);
    }

    @Override
    public double calculaPorcentajeComision() {
        if (this.getRubro().equalsIgnoreCase("SALUD"))
            return 0.80;
        else if (this.getRubro().equalsIgnoreCase("COMERCIO LOCAL"))
            return  0.90;
        else //Es rubro COMERCIO INTERNACIONAL
            return  1.00;
    }
    
    public String getTipo() {
    	return "Persona Juridica";
    }
}
