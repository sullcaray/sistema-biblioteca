import model.*;
import java.time.LocalDateTime;

/**
 * SISTEMA DE BIBLIOTECA - EJEMPLOS PRINCIPIOS SOLID
 * ================================================
 *
 * Este sistema demuestra la aplicación de los 5 principios SOLID:
 * 1. SRP - Single Responsibility Principle
 * 2. OCP - Open/Closed Principle
 * 3. LSP - Liskov Substitution Principle
 * 4. ISP - Interface Segregation Principle
 * 5. DIP - Dependency Inversion Principle
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("🏛️  SISTEMA DE BIBLIOTECA - PRINCIPIOS SOLID");
        System.out.println("=".repeat(50));

        // Crear libros
        Libro libro1 = new Libro("1984", "George Orwell", "978-0-452-28423-4");
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", "978-84-376-0494-7");

        // Crear usuarios
        Usuario usuario1 = new Usuario("Ana García", "U001");
        Usuario usuario2 = new Usuario("Carlos López", "U002");

        // Crear diferentes gestores con distintas configuraciones
        System.out.println("\n📋 GESTOR PARA USUARIOS REGULARES:");
        GestorPrestamos gestorRegular = new GestorPrestamos(
            new MultaEstandar(),
            new NotificadorEmail()
        );

        System.out.println("\n📋 GESTOR PARA ESTUDIANTES:");
        GestorPrestamos gestorEstudiante = new GestorPrestamos(
            new MultaEstudiante(),
            new NotificadorSMS()
        );

        // Realizar préstamos
        System.out.println("\n🔄 REALIZANDO PRÉSTAMOS:");
        Prestamo prestamo1 = gestorRegular.realizarPrestamo(libro1, usuario1);
        Prestamo prestamo2 = gestorEstudiante.realizarPrestamo(libro2, usuario2);

        // Simular devolución tardía
        System.out.println("\n📅 SIMULANDO DEVOLUCIÓN TARDÍA:");
        // Modificamos la fecha para simular retraso
        if (prestamo1 != null) {
            prestamo1.setFechaDevolucion(LocalDateTime.now().minusDays(3));
            gestorRegular.devolverLibro(prestamo1);
        }

        // Devolución a tiempo
        System.out.println("\n📅 DEVOLUCIÓN A TIEMPO:");
        if (prestamo2 != null) {
            gestorEstudiante.devolverLibro(prestamo2);
        }

        // Demostrar extensibilidad con MultaVIP
        System.out.println("\n👑 GESTOR PARA USUARIOS VIP:");
        GestorPrestamos gestorVIP = new GestorPrestamos(
            new MultaVIP(),
            new NotificadorEmail()
        );

        // Crear un nuevo libro y usuario VIP
        Libro libro3 = new Libro("El Quijote", "Miguel de Cervantes", "978-84-376-0495-4");
        Usuario usuarioVIP = new Usuario("María VIP", "U003");

        Prestamo prestamoVIP = gestorVIP.realizarPrestamo(libro3, usuarioVIP);
        if (prestamoVIP != null) {
            // Simular retraso pero sin multa para VIP
            prestamoVIP.setFechaDevolucion(LocalDateTime.now().minusDays(5));
            gestorVIP.devolverLibro(prestamoVIP);
        }
    }
}