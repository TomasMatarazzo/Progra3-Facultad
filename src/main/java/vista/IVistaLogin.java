package vista;

import modelo.usuarios.Usuario;

public interface IVistaLogin extends IVista {

    void setKeyListener();

    void setObservado(Usuario usuario);

    String getNombreUsuario();

    String getContrasena();

    void nombreUsuarioInvalido();

    void contrasenaInvalida();
}
