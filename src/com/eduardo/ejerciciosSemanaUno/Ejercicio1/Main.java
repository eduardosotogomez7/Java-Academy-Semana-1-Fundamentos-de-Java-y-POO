package com.eduardo.ejerciciosSemanaUno.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        /*Ejercicio 1: Hola Mundo Mejorado
          Objetivo: Practicar declaración de variables, tipos primitivos y concatenación de Strings
         */

        String nombre = "Eduardo";
        int edad = 26;
        double altura = 1.80;
        boolean esActivo = true;

        //Impresión de mensaje con concatenación +
        String mensaje1 = "Hola mundo, me llamo " + nombre + " tengo " + edad + " anios, mido " + altura + "m y estoy "
                + (esActivo ? "activo " : "inactivo ");

        System.out.println(mensaje1);

        //Impresion de mensaje utilizando String.format
        String mensaje2 = String.format("Hola mundo, me llamo %s tengo %d anios, mido %.2f m y estoy %s",
                nombre, edad, altura, (esActivo ? "activo " : "inactivo"));

        
        System.out.println(mensaje2);


    }
}
