package com.eduardo.ejerciciosSemanaDos.Ejercicio1;

public class TransactionLog implements AutoCloseable {

    private boolean open = true;


    @Override
    public void close() throws Exception {

        open = false;
        System.out.println("[LOG] TransactionLog cerrado.");

    }

    public void log(String message) {
        if (!open) throw new IllegalStateException("Log cerrado");
        System.out.println("[LOG] " + message);
    }


}
