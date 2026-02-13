package com.eduardo.ejerciciosSemanaUno.Ejercicio5;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Estudiante e1 = new Estudiante("Ana Garcia", "A001");
        Estudiante e2 = new Estudiante("Carlos Lopez", "A002");
        Estudiante e3 = new Estudiante("Maria Torres", "A003");

        e1.agregarCalificacion(95);
        e1.agregarCalificacion(88);
        e1.agregarCalificacion(92);

        e2.agregarCalificacion(78);
        e2.agregarCalificacion(85);
        e2.agregarCalificacion(90);

        e3.agregarCalificacion(100);
        e3.agregarCalificacion(96);
        e3.agregarCalificacion(98);

        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
        listaEstudiantes.add(e1); listaEstudiantes.add(e2); listaEstudiantes.add(e3);

        System.out.println("=== Lista de Estudiantes ===");
        Estudiante mejor = listaEstudiantes.getFirst();
        for (Estudiante e : listaEstudiantes) {
            System.out.println(e);
            if(e.promedio() > mejor.promedio()){
                mejor = e;
            }
        }

        System.out.println("\nMejor promedio: " + mejor.getNombre()
                + " (" + String.format("%.2f", mejor.promedio())
                + ")");
    }
}
