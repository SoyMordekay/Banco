package org.example;

/*
La aplicación debe comenzar con un
inicio de sesión y debe haber un usuario administrador (puede estar codificado)
 que pueda agregar nuevas cuentas de usuario (pero no cuentas de administrador).
*/

import org.example.Entidades.Usuarios;
import org.example.Servicios.ServiciosUsuarios;
import org.example.Servicios.ServiciosBanco;


public class Main {
    public static void main(String[] args) {

        ServiciosUsuarios serviciosUsuarios = new ServiciosUsuarios();
        ServiciosBanco serviciosBanco = new ServiciosBanco();

        // Crear un nuevo usuario
        Usuarios nuevoUsuario = serviciosUsuarios.crearUsuario();

        // Agregar el nuevo usuario a la lista de usuarios en el servicio de Banco
        serviciosBanco.agregarUsuario(nuevoUsuario);
        serviciosBanco.agregarUsuario(nuevoUsuario);


/*        // Intentar iniciar sesión
        boolean inicioSesionExitoso = serviciosBanco.iniciarSesion("julian", "j");
        if (inicioSesionExitoso) {
            // El inicio de sesión fue exitoso, puedes redirigir al usuario a su área personal, por ejemplo.
        } else {
            // El inicio de sesión falló, puedes mostrar un mensaje de error al usuario.
        }*/

        serviciosBanco.mostrarMenu();


        System.out.println("fin");


    }
}