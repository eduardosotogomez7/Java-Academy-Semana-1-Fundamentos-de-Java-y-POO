package com.eduardo.ejerciciosSemanaUno.Ejercicio3;

public class Main {
    public static void main(String[] args) {
        //Ejercicio 3: Clasificador de números
        //Objetivo: Practicar if/else, bucles y lógica condicional.

        int[] datos = {15, -3, 0, 8, -12, 7, 0, 22, -5, 10};
        clasificar(datos);
    }

    public static void clasificar(int[] datos){
        int positivos = 0, negativos = 0, ceros = 0;
        int pares = 0, impares = 0;
        int mayor = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        int suma = 0;

        for(int i = 0; i < datos.length; i++){

            //Clasficar positivo/negativo/cero
            if(datos[i] > 0){
                positivos++;
            }else if(datos[i] < 0){
                negativos++;
            }else {
                ceros++;
            }

            //Clasificar pares/impares
            int modulo = datos[i] % 2;
            if(modulo == 0){
                pares++;
            }else {
                impares++;
            }

            //Actualizar mayor y menor
            if(datos[i] < menor){
                menor = datos[i];
            } else if (datos[i] > mayor) {
                mayor = datos[i];
            }

            //Calcular suma de los elementos
            suma  += datos[i];

        }

        double promedio = (double) suma / datos.length;

        System.out.println("=== Resultados ===");
        System.out.println("Positivos: " + positivos);
        System.out.println("Negativos: " + negativos);
        System.out.println("Ceros: " + ceros);
        System.out.println("Pares: " + pares);
        System.out.println("Impares: " + impares);
        System.out.println("Mayor: " + mayor);
        System.out.println("Menor: " + menor);
        System.out.printf("Promedio: %.2f%n", promedio);

    }
}
