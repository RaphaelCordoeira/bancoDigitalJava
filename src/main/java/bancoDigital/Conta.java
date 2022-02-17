package bancoDigital;

import tools.Utils;

public class Conta {

    private static int contadorDeContas = 1;

    private int numeroConta;
    private Pessoa pessoa;
    private Double saldo = 0.0;

    public Conta(Pessoa pessoa) {
        this.numeroConta = contadorDeContas;
        this.pessoa = pessoa;
        contadorDeContas += 1;
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
        return "\nNúmero da Conta: " + this.getNumeroConta() +
                "\nNome: " +this.pessoa.getNome() +
                "\nCPF: " +this.pessoa.getCpf() +
                "\nEmail: " +this.pessoa.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }

    public void depositar(Double valor){
        if (valor > 0) {
            this.setSaldo(getSaldo() + valor);
            System.out.println("Seu depósito foi realizado com sucesso!");
        } else {
            System.out.println("Nâo foi possível realizar o depósito.");
        }
    }
    public void sacar(Double valor){
        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Seu saque foi realizado com sucesso!");
        } else {
            System.out.println("Nâo foi possível realizar o saque");
        }
    }

    public void transferir(Conta contaDestino, Double valor) {
        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo()- valor);

            contaDestino.saldo = contaDestino.getSaldo() + valor;
            System.out.println("Transfência foi realizado com sucesso!");
        } else {
            System.out.println("Nâo foi possível realizar a transferência");
        }
    }


}
