package model;


//Clase base abstracta para notificaciones
//Aplicando el principio LSP (Liskov Substitution Principle)
public abstract class Notificador {
    public abstract boolean enviar(String mensaje, String destinatario);
}
