package com.academia.batch.model;

public class Instrumento {

    private String nombre;
    private String categoria;
    private double precio;
    private double descuento;

    public Instrumento() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return nombre + " | " + categoria + " | Precio: " + precio + " | Descuento: " + descuento;
    }
}
