package vista;

public interface IVistaAgencia extends IVista{

    void cambiarPagina(int pagina);

    void agregarDatos(String tipoTrabajo,String rangoLaboral,String tipoPuesto);

    void cargarModelo(String dato);

    void limpiaModelo();

    void mostrarDatos();
}
