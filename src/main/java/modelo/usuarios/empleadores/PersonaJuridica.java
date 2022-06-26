package modelo.usuarios.empleadores;

public class PersonaJuridica extends Empleador {

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

	@Override
	public double calculaComision(double remuneracion) {
        double porcentaje;

        porcentaje = calculaPorcentajeComision();

        //Por cada punto obtenido se le resta un 1% al valor de la comisión
        if (this.puntaje > 0)
            porcentaje -= 0 + (0.01 * this.puntaje);

        return remuneracion * porcentaje;
    }

    @Override
    public String getNombre() {
        return "Persona Juridica";
    }
}
