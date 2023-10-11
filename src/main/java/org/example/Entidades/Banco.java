package org.example.Entidades;

import java.util.ArrayList;
import org.example.Entidades.Usuarios;

public class Banco {
     protected ArrayList<Usuarios> listaUsuariosBanco = new ArrayList<>();

    public Banco() {
    }

    public Banco(ArrayList<Usuarios> listaUsuariosBanco) {
        this.listaUsuariosBanco = listaUsuariosBanco;
    }

    public ArrayList<Usuarios> getListaUsuariosBanco() {
        return listaUsuariosBanco;
    }

    public void setListaUsuariosBanco(ArrayList<Usuarios> listaUsuariosBanco) {
        this.listaUsuariosBanco = listaUsuariosBanco;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "listaUsuariosBanco=" + listaUsuariosBanco +
                '}';
    }
}

