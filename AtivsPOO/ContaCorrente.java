public class ContaCorrente extends Conta {
    
    double limite;

    ContaCorrente(String numero, Pessoa titular, Gerente gerente, Data criacao) {
        super(numero, titular, gerente, criacao);
        this.limite = 200;
    }

    /**
     * Retorna o valor disponível para saque dessa conta,
     * que é a soma do saldo com o limite.
     */
    double disponivel() {
        return this.saldo + this.limite;
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

    /**
     * Imprime os dados da conta
     */
    void extrato() {
        System.out.println(" *** EXTRATO DA CONTA *** ");
        System.out.println("Conta: " + this.numero);
        System.out.println("Titular: " + this.titular.nome);
        System.out.printf("Valor disponivel para saque : R$%.2f\n", this.disponivel());
    }

    /**
     * Faz um empréstimo a cheque especial para a conta.
     * Se o saldo da conta estiver negativo, vai aplicar 
     * os juros em cima, negativando ainda mais.
     * Os juros são em porcentagem, então 0.5 equivale a
     * 0.5%.
     */
    void chequeEspecial(double juros) {
        if (this.saldo < 0) {
            this.saldo = this.saldo * (1 + juros/100);
        }
    }
}
