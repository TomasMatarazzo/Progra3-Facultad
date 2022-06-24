package vista;

import modelo.excepciones.DatosMalIngresadosException;

public interface IVistaRegister extends IVista {

    void setKeyListener();

    boolean esEmpleado();

    String getTipoUsuario();

    String getNombreUsuario();

    String getContrasena();

    String getNombre();

    String getApellido();

    String getTelefono();

    int getEdad() throws DatosMalIngresadosException;

    String getEmail();

    String getRazonSocial();

    String getRubro();

    void muestraOpcionEmpleado();

    void muestraOpcionEmpleador();

    void nombreUsuarioInvalido();
}
