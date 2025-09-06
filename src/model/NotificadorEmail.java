package model;


 //Notifica por email
 // Implementación concreta de Notificador
public class NotificadorEmail extends Notificador {
    @Override
    public boolean enviar(String mensaje, String destinatario) {
        System.out.println("📧 Email a " + destinatario + ": " + mensaje);
        return true;
    }
}
