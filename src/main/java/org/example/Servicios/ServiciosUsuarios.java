package org.example.Servicios;

import org.example.Entidades.Usuarios;

public class ServiciosUsuarios extends Usuarios {

    public Usuarios crearUsuario() {
        System.out.println("******************** " + "Crear Usuario Adminitrador " + "********************************************");

        Usuarios nuevoUsuario = new Usuarios("julian", "j",true, 1000 );
        return nuevoUsuario;
    } // crear Usuario admin ****************************************************************
}
