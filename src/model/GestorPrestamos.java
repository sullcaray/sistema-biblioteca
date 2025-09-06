package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

// Aplicando el principio DIP (Dependency Inversion Principle)
public class GestorPrestamos {
    private CalculadoraMulta calculadoraMulta;
    private Notificador notificador;
    private List<Prestamo> prestamos;

    public GestorPrestamos(CalculadoraMulta calculadoraMulta, Notificador notificador) {
        this.calculadoraMulta = calculadoraMulta;
        this.notificador = notificador;
        this.prestamos = new ArrayList<>();
    }

    public Prestamo realizarPrestamo(Libro libro, Usuario usuario) {
        if (!libro.isDisponible()) {
            System.out.println("❌ El libro '" + libro.getTitulo() + "' no está disponible");
            return null;
        }

        libro.setDisponible(false);
        Prestamo prestamo = new Prestamo(libro, usuario);
        prestamos.add(prestamo);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String mensaje = "Has prestado '" + libro.getTitulo() + "'. Fecha de devolución: " +
                        prestamo.getFechaDevolucion().format(formatter);
        notificador.enviar(mensaje, usuario.getNombre());

        System.out.println("✅ Préstamo realizado: '" + libro.getTitulo() + "' para " + usuario.getNombre());
        return prestamo;
    }

    public void devolverLibro(Prestamo prestamo) {
        if (prestamo.isDevuelto()) {
            System.out.println("❌ Este libro ya fue devuelto");
            return;
        }

        LocalDateTime fechaActual = LocalDateTime.now();
        if (fechaActual.isAfter(prestamo.getFechaDevolucion())) {
            int diasRetraso = (int) ChronoUnit.DAYS.between(prestamo.getFechaDevolucion(), fechaActual);
            double multa = calculadoraMulta.calcular(diasRetraso);
            System.out.println("⚠️  Retraso de " + diasRetraso + " días. Multa: $" + multa);
        } else {
            System.out.println("✅ Libro devuelto a tiempo");
        }

        prestamo.setDevuelto(true);
        prestamo.getLibro().setDisponible(true);
        System.out.println("📚 '" + prestamo.getLibro().getTitulo() + "' devuelto por " + prestamo.getUsuario().getNombre());
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
}
