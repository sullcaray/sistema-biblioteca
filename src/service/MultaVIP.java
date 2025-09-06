package service;

import service.interfaces.CalculadoraMulta;

//Sin multa para usuarios VIP
//Implementación concreta de CalculadoraMulta
public class MultaVIP extends CalculadoraMulta {
    @Override
    public double calcular(int diasRetraso) {
        return 0;
    }
}
