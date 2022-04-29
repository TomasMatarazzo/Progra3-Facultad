package modelo.listas;

import modelo.usuarios.Usuario;
import java.util.TreeSet;

public abstract class Lista {
    private TreeSet<Usuario> candidatos = new TreeSet<Usuario>(); //Coleccion
    private int eleccion; //Corresponde al ID del ticket
}
