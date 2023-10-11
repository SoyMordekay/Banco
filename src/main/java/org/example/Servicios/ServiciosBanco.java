package org.example.Servicios;

import org.example.Entidades.Banco;
import org.example.Entidades.Usuarios;

import java.util.ArrayList;
import java.util.Scanner;

public class ServiciosBanco extends Banco {
    Scanner scanner = new Scanner(System.in);

    private Usuarios usuarioActual;

    ArrayList<Usuarios> listaDeUsuariosBanco = getListaUsuariosBanco();

    public ServiciosBanco() {
    }

    public void agregarUsuario(Usuarios usuario) {
        listaDeUsuariosBanco.add(usuario);
        System.out.println(listaDeUsuariosBanco.toString());
    }

    public boolean iniciarSesion() {
        System.out.println("nombre de Usuario");
        String nombreUsuario = scanner.next();
        System.out.println("contraseña");
        String pass = scanner.next();

        for (Usuarios usuario : listaDeUsuariosBanco) {
            if (usuario.getNombre().equals(nombreUsuario) && usuario.getPass().equals(pass)) {
                usuarioActual = usuario;
                System.out.println("Inicio de sesión exitoso para " + nombreUsuario);
                return true;
            }
        }
        System.out.println("Credenciales inválidas. El inicio de sesión ha fallado.");
        return false;
    }

    public void mostrarMenu() {

        while (true) {
            System.out.println("\nMenú del Banco");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Salir");

            if (usuarioActual != null) {
                System.out.println("3. Depositar dinero");
                System.out.println("4. Retirar dinero");
                System.out.println("5. Transferir dinero");
            }

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    iniciarSesion( ); // Aquí se inicia sesión con nombre de usuario y contraseña.
                    break;
                case 2:
                    System.out.println("Saliendo del banco. ¡Hasta luego!");
                    return;
                case 3:
                    if (usuarioActual != null) {
                        depositarDinero();
                    } else {
                        System.out.println("Debes iniciar sesión primero.");
                    }
                    break;
                case 4:
                    if (usuarioActual != null) {
                        retirarDinero();
                    } else {
                        System.out.println("Debes iniciar sesión primero.");
                    }
                    break;
                case 5:
                    if (usuarioActual != null) {
                        transferirDinero();
                    } else {
                        System.out.println("Debes iniciar sesión primero.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private void depositarDinero() {
        System.out.print("Cantidad a depositar: ");
        double cantidad = scanner.nextDouble();

        if (cantidad > 0) {
            usuarioActual.depositarDinero(cantidad);
            System.out.println("Depósito exitoso. Saldo actual: " + usuarioActual.getDinero());
        } else {
            System.out.println("La cantidad de depósito debe ser mayor que cero.");
        }
    }

    private void retirarDinero() {
        System.out.print("Cantidad a retirar: ");
        double cantidad = scanner.nextDouble();

        boolean retiroExitoso = usuarioActual.retirarDinero(cantidad);

        if (retiroExitoso) {
            System.out.println("Retiro exitoso. Saldo actual: " + usuarioActual.getDinero());
        } else {
            System.out.println("Fondos insuficientes o cantidad inválida para realizar el retiro.");
        }
    }

    private void transferirDinero() {
        scanner.nextLine(); // Limpiar el búfer de entrada
        System.out.print("Nombre de usuario de destino: ");
        String nombreDestino = scanner.nextLine();
        System.out.print("Cantidad a transferir: ");
        double cantidad = scanner.nextDouble();

        Usuarios usuarioDestino = buscarUsuarioPorNombre(nombreDestino);

        if (usuarioDestino != null) {
            boolean transferenciaExitosa = usuarioActual.transferirDinero(usuarioDestino, cantidad);

            if (transferenciaExitosa) {
                System.out.println("Transferencia exitosa. Saldo actual: " + usuarioActual.getDinero());
            } else {
                System.out.println("Fondos insuficientes o cantidad inválida para realizar la transferencia.");
            }
        } else {
            System.out.println("El usuario de destino no existe.");
        }
    }

    private Usuarios buscarUsuarioPorNombre(String nombreUsuario) {
        for (Usuarios usuario : listaDeUsuariosBanco) {
            if (usuario.getNombre().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null;
    }
}
