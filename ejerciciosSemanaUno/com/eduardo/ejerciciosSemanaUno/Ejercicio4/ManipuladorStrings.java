package com.eduardo.ejerciciosSemanaUno.Ejercicio4;

public class ManipuladorStrings {
    public static void main(String[] args) {

        System.out.println("Ejercicio 4 - ManipuladorStrings");

        System.out.println("Invertir 'Hola Mundo': "
                + invertir("Hola Mundo"));
        System.out.println("'Anita lava la tina' es palindromo: "
                + esPalindromo("Anita lava la tina"));
        System.out.println("Vocales en 'Murcielago': "
                + contarVocales("Murcielago"));
        System.out.println("Piramide de 5 niveles:");
        System.out.println(construirPiramide(5));




    }

    public static String invertir(String palabra){
        StringBuilder palabraInvertido = new StringBuilder(palabra).reverse();
        return palabraInvertido.toString();
    }

    public static boolean esPalindromo(String palabra){
        palabra = palabra.toLowerCase().replaceAll(" ","");
        return palabra.equals(invertir(palabra));
    }

    public static int contarVocales(String palabra){
        int count = 0;
        String vocales = "aeiouAEIOU";

        for(int i = 0; i < palabra.length(); i++){
            if(vocales.indexOf(palabra.charAt(i)) != -1){
                count++;
            }
        }

        return count;
    }

    public static String construirPiramide(int niveles){
        StringBuilder piramide = new StringBuilder();
        for(int i = 1; i <= niveles; i++){
            

            piramide.append(" ".repeat(niveles - i));

            piramide.append("*".repeat((2*i)-1));

            piramide.append("\n");

        }

        return piramide.toString();
    }




}
