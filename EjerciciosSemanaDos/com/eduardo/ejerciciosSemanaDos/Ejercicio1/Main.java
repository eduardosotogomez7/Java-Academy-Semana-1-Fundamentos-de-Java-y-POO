package com.eduardo.ejerciciosSemanaDos.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        BankAccount cuenta1 = new BankAccount(1000.00);
        BankAccount cuenta2 = new BankAccount(500.00);

        // Operaciones validas
        try {
            cuenta1.deposit(500);
            System.out.printf("Deposito exitoso. Saldo: $%.2f%n", cuenta1.getMontoActual());

            cuenta1.withdraw(200);
            System.out.printf("Retiro exitoso. Saldo: $%.2f%n", cuenta1.getMontoActual());

            cuenta1.transfer(cuenta2, 300);
            System.out.printf("Transferencia exitosa. Saldo cuenta1: $%.2f, cuenta2: $%.2f%n",
                    cuenta1.getMontoActual(), cuenta2.getMontoActual());
        } catch (InsufficientBalanceException | InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }



        System.out.println("\n=== Manejo de Errores ===");


        try {
            cuenta1.deposit(-100);
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }


        try {
            cuenta1.withdraw(999999);
        } catch (InsufficientBalanceException e) {
            System.out.printf("Error: %s (deficit: $%.2f)%n",
                    e.getMessage(), e.getDeficit());
        }
    }
}
