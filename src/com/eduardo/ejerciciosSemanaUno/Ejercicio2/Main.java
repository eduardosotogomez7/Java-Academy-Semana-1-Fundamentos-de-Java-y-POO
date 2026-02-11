package com.eduardo.ejerciciosSemanaUno.Ejercicio2;

public class Main {
    public static void main(String[] args) {

        //Ejercicio 2: Calculadora Básica
        // Objetivo: Practicar la sobrecarga de métodos

        System.out.println("Ejercicio 2\n");

        System.out.println("5 + 7 = " + Calculadora.sumar(5, 7));
        System.out.println("2.5 + 14.2 = " + Calculadora.sumar(2.5, 14.2));
        System.out.println("3 + 8 + 10 = " + Calculadora.sumar(3,8,10));

        int[] numeros = {10,20,30,40};

        System.out.println("Array suma = " +  Calculadora.sumar(numeros));

    }
}
