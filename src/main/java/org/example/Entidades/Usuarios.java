package org.example.Entidades;

public class Usuarios {

    protected String nombre;
    protected String pass = "j";
    protected boolean admin = false;
    protected float dinero = 0;

    public Usuarios() {
    }

    public Usuarios(String nombre, String pass, boolean admin, float dinero) {
        this.nombre = nombre;
        this.pass = pass;
        this.admin = admin;
        this.dinero = dinero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public float getDinero() {
        return dinero;
    }

    public void setDinero(float dinero) {
        this.dinero = dinero;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "nombre='" + nombre + '\'' +
                ", pass='" + pass + '\'' +
                ", admin=" + admin +
                ", dinero=" + dinero +
                '}';
    }

    // Método para depositar dinero
    public void depositarDinero(double cantidad) {
        if (cantidad > 0) {
            dinero += cantidad;
            System.out.println("Depósito exitoso. Saldo actual: " + dinero);
        } else {
            System.out.println("La cantidad de depósito debe ser mayor que cero.");
        }
    }

    // Método para retirar dinero
    public boolean retirarDinero(double cantidad) {
        if (cantidad > 0 && dinero >= cantidad) {
            dinero -= cantidad;
            System.out.println("Retiro exitoso. Saldo actual: " + dinero);
            return true;
        } else {
            System.out.println("Fondos insuficientes o cantidad inválida para realizar el retiro.");
            return false;
        }
    }

    // Método para transferir dinero a otro usuario
    public boolean transferirDinero(Usuarios usuarioDestino, double cantidad) {
        if (cantidad > 0 && dinero >= cantidad) {
            dinero -= cantidad;
            usuarioDestino.depositarDinero(cantidad);
            System.out.println("Transferencia exitosa. Saldo actual: " + dinero);
            return true;
        } else {
            System.out.println("Fondos insuficientes o cantidad inválida para realizar la transferencia.");
            return false;
        }
    }
}



