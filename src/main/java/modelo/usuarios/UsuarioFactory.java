package modelo.usuarios;

import excepciones.DatosMalIngresadosException;
import modelo.usuarios.empleadores.PersonaFisica;
import modelo.usuarios.empleadores.PersonaJuridica;

public class UsuarioFactory {

    public Usuario crearUsuario(String nombreUsuario, String contrasena,String tipo) throws DatosMalIngresadosException {
        Usuario nuevo;

        if (tipo.equalsIgnoreCase("AGENCIA"))
            return nuevo = Agencia.getInstance(nombreUsuario,contrasena);
        else
            if (tipo.equalsIgnoreCase("EMPLEADO PRETENSO"))
                return nuevo = new Empleado_Pretenso(nombreUsuario,contrasena);
            else
                if (tipo.equalsIgnoreCase("PERSONA FISICA"))
                    return nuevo = new PersonaFisica(nombreUsuario,contrasena);
                else
                    if (tipo.equalsIgnoreCase("PERSONA JURIDICA"))
                        return nuevo = new PersonaJuridica(nombreUsuario,contrasena);
                    else
                        throw new DatosMalIngresadosException("Tipo Usuario");
    }
}
