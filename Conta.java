import java.util.Scanner;

class Conta {
    
    protected String numero;
    protected Pessoa titular;
    protected Data criacao;
    protected double saldo;
    protected Gerente gerente;

    public Conta(Gerente gerente) {
        Scanner leitor = new Scanner(System.in);

        this.titular = new Pessoa();
        this.saldo = 0;
        this.gerente = gerente;

        System.out.print("Informe o número da conta: ");
        this.numero = leitor.next();

        System.out.print("Informe a data de criação da conta: ");
        this.criacao = new Data();

        System.out.println();
    }

    public Conta(String numero, Pessoa titular, Data criacao, Gerente gerente) {
        this.numero = numero;
        this.titular = titular;
        this.gerente = gerente;
        this.criacao = criacao;
        this.saldo = 0;
    }

    protected double disponivel() {
        return this.saldo;
    }

    public void extrato() {
        System.out.println("Conta: " + this.numero);
        System.out.println("Titular: " + this.titular.getNome());
        System.out.printf("Valor disponivel para saque : R$%.2f\n\n", this.disponivel());
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Deposito de " + valor + " realizado com sucesso.");
        System.out.printf("Novo saldo: R$%.2f\n\n", this.saldo);
    }

    /**
     * Tenta sacar o valor da conta, se ele estiver disponível;
     * retorna se foi possível realizar o saque.
     */
    public boolean sacar(double valor) {
        if (this.disponivel() >= valor) {
            this.saldo -= valor;

            System.out.println("Saque de " + valor + " realizado com sucesso.");
            System.out.println("Novo saldo: " + this.saldo + "\n");

            return true;
        }

        System.out.println("Erro: nao foi possivel sacar " + valor);
        System.out.println("Valor disponivel para saque: " + this.disponivel() + "\n");
        return false;
    }

    /**
     * Tenta transferir o valor da conta atual para a conta
     * destino, se o valor estiver disponível na primeira;
     * retorna se foi possível realizar a transferência.
     */
    public boolean transferir(double valor, Conta destino) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }
}
