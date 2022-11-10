package Programa;


import utilitarios.Utils;

import javax.swing.*;

public class Conta {

    private static int countadorDeContas = 1;

   private int numeroConta;
   private Pessoa pessoa;
   private Double saldo = 0.0;

    public Conta(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.numeroConta = countadorDeContas;
        countadorDeContas += 1;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String toString(){
        return "\nNúmero da conta: " + this.getNumeroConta() +
                "\nNome: " + this.pessoa.getNome() +
                "\nCPF: " + this.pessoa.getCpf() +
                "\nEmail: " + this.pessoa.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }

    public void depositar(Double valor){
        if(valor>0){
            setSaldo(getSaldo() + valor);
            JOptionPane.showMessageDialog(null, "Seu depósito foi realizado com sucesso!");
        } else{
            JOptionPane.showMessageDialog(null, "Não foi possivel realizar o depósito!");
        }
    }

    public void sacar(Double valor){
        if(valor>0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso");
        } else{
            JOptionPane.showMessageDialog(null, "Não foi possivel realizar o saque!");
        }
    }

    public void transferir(Conta contaParaDeposito, Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);

            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            JOptionPane.showMessageDialog(null, "Transferencia realizada com sucesso");
        } else{
            JOptionPane.showMessageDialog(null, "Não foi possivel realizar a transferencia!");
        }
    }
}
