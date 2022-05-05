package modelo.usuarios;

import excepciones.DatosMalIngresadosException;
import excepciones.ErrorDeUsuarioException;
import modelo.Sistema;
import modelo.usuarios.empleadores.Empleador;
import modelo.usuarios.empleadores.PersonaFisica;
import modelo.usuarios.empleadores.PersonaJuridica;

public class UsuarioFactory {
    private Sistema sistema = Sistema.getInstance();

    public void creaUsuario(String nombreUsuario, String contrasena, String tipo) throws DatosMalIngresadosException {
        Usuario nuevo;

        try {
            if (tipo.equalsIgnoreCase("EMPLEADO PRETENSO")) {
                nuevo = new Empleado_Pretenso(nombreUsuario, contrasena);
                sistema.registrarUsuario((Empleado_Pretenso) nuevo);
            } else {
                if (tipo.equalsIgnoreCase("PERSONA FISICA"))
                    nuevo = new PersonaFisica(nombreUsuario, contrasena);
                else
                    if (tipo.equalsIgnoreCase("PERSONA JURIDICA"))
                        nuevo = new PersonaJuridica(nombreUsuario, contrasena);
                    else
                        throw new DatosMalIngresadosException("Tipo Usuario");
                sistema.registrarUsuario((Empleador) nuevo);
            }
        }
        catch (ErrorDeUsuarioException e1) {
            System.out.println(e1.getMessage());
        }
    }
}
