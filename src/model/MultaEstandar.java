package model;


//Multa estándar de $10 por día
//Implementación concreta de CalculadoraMulta
public class MultaEstandar extends CalculadoraMulta {
    @Override
    public double calcular(int diasRetraso) {
        return diasRetraso * 10;
    }
}
