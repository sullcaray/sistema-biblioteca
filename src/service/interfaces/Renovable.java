package service.interfaces;

import model.Prestamo;

//Aplicando el principio ISP (Interface Segregation Principle)
public interface Renovable {

    boolean renovar(Prestamo prestamo);
}
