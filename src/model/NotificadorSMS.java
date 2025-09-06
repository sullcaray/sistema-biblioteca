package model;

/**
 * Notifica por SMS
 * Implementación concreta de Notificador
 */
public class NotificadorSMS extends Notificador {
    @Override
    public boolean enviar(String mensaje, String destinatario) {
        System.out.println("📱 SMS a " + destinatario + ": " + mensaje);
        return true;
    }
}
