package com.eduardo.ejerciciosSemanaUno.Ejercicio2;

public class Calculadora {

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static double sumar(double a, double b) {
        return a + b;
    }

    public static int sumar(int a, int b, int c) {
        return a + b + c;
    }

    public static int sumar(int[] numeros){

        int resultado = 0;
        for (int numero : numeros) {
            resultado += numero;
        }

        return resultado;
    }
}
