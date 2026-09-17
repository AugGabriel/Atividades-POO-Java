class Conta {
    
    String numero;
    double saldo;
    Pessoa titular;
    Data criacao;
    Gerente gerente;

    Conta(String numero, Pessoa titular, Gerente gerente, Data criacao) {
        this.numero = numero;
        this.titular = titular;
        this.gerente = gerente;
        this.criacao = criacao;
        this.saldo = 0;
    }

    void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Deposito de " + valor + " realizado com sucesso.");
        System.out.println("Novo saldo: " + this.saldo);
    }
}
