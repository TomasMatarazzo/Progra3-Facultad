package modelo.usuarios;

import modelo.excepciones.DatosMalIngresadosException;
import modelo.excepciones.ErrorDeUsuarioException;
import modelo.Sistema;
import modelo.usuarios.empleadores.PersonaFisica;
import modelo.usuarios.empleadores.PersonaJuridica;

public class UsuarioFactory {

    public void creaUsuario(String nombreUsuario, String contrasena, String tipo) throws DatosMalIngresadosException, ErrorDeUsuarioException {
        if (tipo.equalsIgnoreCase("Agencia"))
            if (Sistema.getInstance().getAgencia() == null)
                Sistema.getInstance().setAgencia(new Agencia(nombreUsuario,contrasena));
            else
                throw new DatosMalIngresadosException("Ya existe una Agencia guardada en el sistema");
        else
            if (tipo.equalsIgnoreCase("Empleado"))
                Sistema.getInstance().registrarUsuario(new EmpleadoPretenso(nombreUsuario, contrasena));
            else
                if (tipo.equalsIgnoreCase("Persona Fisica"))
                    Sistema.getInstance().registrarUsuario(new PersonaFisica(nombreUsuario, contrasena));
                else
                    if (tipo.equalsIgnoreCase("Persona Juridica"))
                        Sistema.getInstance().registrarUsuario(new PersonaJuridica(nombreUsuario, contrasena));
                    else
                        throw new DatosMalIngresadosException("Tipo de Usuario ingresado incorrecto");
    }
}
