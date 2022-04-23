package modelo.listas;

import modelo.Usuarios.Usuario;
import java.util.TreeSet;

public abstract class Listas {
    private TreeSet<Usuario> candidatos = new TreeSet<Usuario>(); //Coleccion
    private int eleccion; //Corresponde al ID del ticket
}
