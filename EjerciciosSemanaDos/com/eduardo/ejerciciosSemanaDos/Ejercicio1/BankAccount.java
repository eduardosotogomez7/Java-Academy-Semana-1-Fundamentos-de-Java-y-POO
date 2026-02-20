package com.eduardo.ejerciciosSemanaDos.Ejercicio1;

public class BankAccount {


    private double montoActual;
    private boolean locked;

    public BankAccount(double saldoInicial) {
        this.montoActual = saldoInicial;
        this.locked = false;
    }

    public void deposit(double valor) {
        if(valor <= 0) throw new InvalidAmountException("Error: Monto inválido: " + valor);
        montoActual += valor;
    }

    public void withdraw(double ammount) throws InsufficientBalanceException {
        if(ammount < 0) throw new InvalidAmountException("Monto invalido" + ammount);
        if(ammount > montoActual){
            double deficit = ammount - montoActual;
            throw new InsufficientBalanceException("Monto insuficiente", deficit );
        }
        montoActual -= ammount;
    }

    public void transfer(BankAccount destino, double ammount) throws InsufficientBalanceException {
        try (TransactionLog transactionLog = new TransactionLog()){
            withdraw(ammount);
            destino.deposit(ammount);
            transactionLog.log("Retiro de " + ammount + "de cuenta origen. Saldo: " + montoActual);
            transactionLog.log("Deposito de " + ammount + " en cuenta destino: " + destino.montoActual);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void lock(){
        this.locked = true;
    }

    public double getMontoActual(){
        return this.montoActual;
    }

}
