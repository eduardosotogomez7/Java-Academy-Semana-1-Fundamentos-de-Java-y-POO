package com.eduardo.ejerciciosSemanaUno.Ejercicio5;

import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private String matricula;
    private ArrayList<Double> calificaciones;

    public Estudiante(String nombre, String matricula){
        this.nombre = nombre;
        this.matricula = matricula;
        this.calificaciones = new ArrayList<>();
    }

    //Getters
    public String getNombre() {
        return nombre;
    }
    public String getMatricula() {
        return matricula;
    }

    public void agregarCalificacion(double calificacion){
        if(calificacion >= 0 && calificacion <= 100){
            this.calificaciones.add(calificacion);
        }else{
            System.out.println("Calificaión inválida " +  calificacion);
        }
    }

    //calcular promedio
    public double promedio(){
        if(calificaciones.isEmpty()){
            return 0;
        }else{
            double suma = 0;
            for (Double calificacion : calificaciones) {
                suma += calificacion;
            }

            return suma / calificaciones.size();
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Estudiante{nombre='%s', matricula='%s', promedio=%.2f}",
                nombre, matricula, promedio());
    }
}
