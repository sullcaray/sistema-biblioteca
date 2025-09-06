package service.interfaces;

//Interface solo para reservar
//Aplicando el principio ISP (Interface Segregation Principle)

import model.Usuario;

public interface Reservable {
    boolean reservar(Usuario usuario);
}
