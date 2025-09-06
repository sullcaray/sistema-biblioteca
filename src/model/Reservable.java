package model;

//Interface solo para reservar
//Aplicando el principio ISP (Interface Segregation Principle)

public interface Reservable {
    boolean reservar(Usuario usuario);
}
