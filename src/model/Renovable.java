package model;

//Aplicando el principio ISP (Interface Segregation Principle)
public interface Renovable {

    boolean renovar(Prestamo prestamo);
}
