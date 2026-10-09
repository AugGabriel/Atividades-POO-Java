class Conta {
    
    protected String numero;
    protected Pessoa titular;
    protected Data criacao;
    protected double saldo;
    protected Gerente gerente;

    public Conta(Gerente gerente, Pessoa titular) {
        this.titular = titular;
        this.saldo = 0;
        this.gerente = gerente;

        System.out.print("Informe o número da conta: ");
        this.numero = Leitor.primeiraPalavra();

        System.out.println("Informe a data de criação da conta:");
        this.criacao = new Data();

        System.out.println("\nConta cadastrada com sucesso!\n");
    }
    
    public Conta(String numero, Pessoa titular, Data criacao, Gerente gerente) {
        this.numero = numero;
        this.titular = titular;
        this.gerente = gerente;
        this.criacao = criacao;
        this.saldo = 0;
        
        System.out.println("\nConta cadastrada com sucesso!\n");
    }

    protected double disponivel() {
        return this.saldo;
    }

    public void extrato() {
        System.out.println("Conta: " + this.numero);
        System.out.println("Titular: " + this.titular.getNome());
        System.out.printf("Valor disponivel para saque : R$%.2f\n\n", this.disponivel());
    }

    public boolean depositar(double valor) {
        if (valor < 0) {
            System.out.println("\nNão é possível realizar depósitos com valores negativos\n");
            return false;
        }

        this.saldo += valor;
        System.out.println("Depósito de " + valor + " realizado com sucesso.");
        System.out.printf("Novo saldo: R$%.2f\n\n", this.saldo);
        return true;
    }

    /**
     * Tenta sacar o valor da conta, se ele estiver disponível;
     * retorna se foi possível realizar o saque.
     */
    public boolean sacar(double valor) {
        if (valor < 0) {
            System.out.println("\nNão é possível realizar saques com valores negativos\n");
            return false;
        }

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
        if (destino == this) {
            System.out.println("\nNão é possível realizar transferências para a mesma conta\n");
            return false;
        }

        if (this.sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }
}
