package model;

//Sin multa para usuarios VIP
//Implementación concreta de CalculadoraMulta
public class MultaVIP extends CalculadoraMulta {
    @Override
    public double calcular(int diasRetraso) {
        return 0;
    }
}
