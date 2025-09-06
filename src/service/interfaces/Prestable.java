package service.interfaces;

import model.Usuario;

/**
 * Interface solo para prestar
 * Aplicando el principio ISP (Interface Segregation Principle)
 */
public interface Prestable {
    boolean prestar(Usuario usuario);
}
