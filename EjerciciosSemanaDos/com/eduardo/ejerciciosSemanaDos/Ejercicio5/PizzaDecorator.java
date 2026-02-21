package com.eduardo.ejerciciosSemanaDos.Ejercicio5;


abstract class PizzaDecorator implements PizzaOrder {
    protected final PizzaOrder wrapped;
    PizzaDecorator(PizzaOrder wrapped) { this.wrapped = wrapped; }
}