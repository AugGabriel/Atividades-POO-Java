import java.util.Scanner;

class Conta {
    
    String numero;
    Pessoa titular;
    Data criacao;
    double saldo;
    Gerente gerente;

    Conta(Gerente gerente) {
        Scanner leitor = new Scanner(System.in);

        this.titular = new Pessoa();
        this.saldo = 0;
        this.gerente = gerente;

        System.out.println("Informe o número da conta: ");
        this.numero = leitor.next();

        System.out.println("Informe a data de criação da conta: ");
        this.criacao = new Data();

        leitor.close();
    }

    Conta(String numero, Pessoa titular, Data criacao, Gerente gerente) {
        this.numero = numero;
        this.titular = titular;
        this.gerente = gerente;
        this.criacao = criacao;
        this.saldo = 0;
    }

    double disponivel() {
        return this.saldo;
    }

    void extrato() {
        System.out.println("Conta: " + this.numero);
        System.out.println("Titular: " + this.titular.nome);
        System.out.printf("Valor disponivel para saque : R$%.2f\n", this.disponivel());
    }

    void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Deposito de " + valor + " realizado com sucesso.");
        System.out.println("Novo saldo: " + this.saldo);
    }

    /**
     * Tenta sacar o valor da conta, se ele estiver disponível;
     * retorna se foi possível realizar o saque.
     */
    boolean sacar(double valor) {
        if (this.disponivel() >= valor) {
            this.saldo -= valor;

            System.out.println("Saque de " + valor + " realizado com sucesso.");
            System.out.println("Novo saldo: " + this.saldo);

            return true;
        }

        System.out.println("Erro: nao foi possivel sacar " + valor);
        System.out.println("Valor disponivel para saque: " + this.disponivel());
        return false;
    }

    /**
     * Tenta transferir o valor da conta atual para a conta
     * destino, se o valor estiver disponível na primeira;
     * retorna se foi possível realizar a transferência.
     */
    boolean transferir(double valor, Conta destino) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }
}
