package modelo.usuarios;

import excepciones.DatosMalIngresadosException;
import excepciones.ErrorDeUsuarioException;
import modelo.Sistema;
import modelo.usuarios.empleadores.PersonaFisica;
import modelo.usuarios.empleadores.PersonaJuridica;

public class UsuarioFactory {
    private Sistema sistema = Sistema.getInstance();

    public void creaUsuario(String nombreUsuario, String contrasena, String tipo) throws DatosMalIngresadosException {
        try {
            if (tipo.equalsIgnoreCase("AGENCIA"))
                sistema.setAgencia(new Agencia(nombreUsuario,contrasena));
            else
                if (tipo.equalsIgnoreCase("EMPLEADO PRETENSO"))
                    sistema.registrarUsuario(new Empleado_Pretenso(nombreUsuario, contrasena));
                else
                    if (tipo.equalsIgnoreCase("PERSONA FISICA"))
                        sistema.registrarUsuario(new PersonaFisica(nombreUsuario, contrasena));
                    else
                        if (tipo.equalsIgnoreCase("PERSONA JURIDICA"))
                            sistema.registrarUsuario(new PersonaJuridica(nombreUsuario, contrasena));
                        else
                            throw new DatosMalIngresadosException("Tipo Usuario");
        }
        catch (ErrorDeUsuarioException e1) {
            System.out.println(e1.getMessage());
        }
    }
}
