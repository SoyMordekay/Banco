package org.example.Servicios.Servicios;

import org.example.Entidades.Banco;
import org.example.Entidades.Usuarios;

import java.util.ArrayList;
import java.util.Scanner;

public class ServiciosBanco extends Banco {
    Scanner scanner = new Scanner(System.in);

    ArrayList<Usuarios> listaDeUsuariosBanco = getListaUsuariosBanco();


    public void agregarUsuario(Usuarios usuario) {
        listaDeUsuariosBanco.add(usuario);
        System.out.println(listaDeUsuariosBanco.toString());

    }



    public boolean iniciarSesion(String nombreUsuario, String contrasena) {
        for (Usuarios usuario : UsuariosBanco) {
            if (usuario.getNombre().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                System.out.println("Inicio de sesión exitoso para " + nombreUsuario);
                return true;
            }
        }
        System.out.println("Credenciales inválidas. El inicio de sesión ha fallado.");
        return false;
    }

    // Intentar iniciar sesión
    boolean inicioSesionExitoso = iniciarSesion("nombreUsuario", "contrasenaSegura");
        if (inicioSesionExitoso) {
        // El inicio de sesión fue exitoso, puedes redirigir al usuario a su área personal, por ejemplo.





    } else {
        // El inicio de sesión falló, puedes mostrar un mensaje de error al usuario.
    }








/*    public boolean validarCredenciales(Usuarios usuario,String nombreUsuario, String contrasena) {

        return usuario.getNombre().equals(nombreUsuario) && usuario.getPass().equals(contrasena);
    }


    public boolean login() {
        System.out.println(listaDeUsuariosBanco + "usuario banco");
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.next();
        System.out.print("Contraseña: ");
        String contrasena = scanner.next();

        for (Usuarios usuario : getListaUsuariosBanco()) {
            if (validarCredenciales(usuario,nombreUsuario, contrasena)) {
                System.out.println("Inicio de sesión exitoso para " + nombreUsuario);
                return true;
            }
        }
        System.out.println("Credenciales inválidas. El inicio de sesión ha fallado.");
        return false; // Devuelve false si las credenciales no son válidas
    }*/  // login *****************************************************************



    /*public void retiro(Usuario usuario) {
        if (usuario != null) {
            System.out.println("Cuánto dinero desea retirar: ");
            float dineroRetiro = scanner.nextFloat();

            if (dineroRetiro <= usuario.getDinero()) {
                usuario.setDinero(usuario.getDinero() - dineroRetiro);
                System.out.println("Ha retirado " + dineroRetiro + ". Su saldo disponible es: " + usuario.getDinero());
            } else {
                System.out.println("No tiene suficiente dinero. Saldo actual: " + usuario.getDinero());
            }
        } else {
            System.out.println("No se puede realizar el retiro, inicie sesión primero.");
        }
    }*/

    //public void traferir(){}

    //public void consignar(){}

}
