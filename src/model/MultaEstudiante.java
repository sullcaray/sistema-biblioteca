package model;

//Multa reducida para estudiantes: $5 por día
//Implementación concreta de CalculadoraMulta
public class MultaEstudiante extends CalculadoraMulta {
    @Override
    public double calcular(int diasRetraso) {
        return diasRetraso * 5;
    }
}
