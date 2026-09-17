public class ContaCorrente extends Conta {
    
    double limite;
    
    alterarLimite()

    alterarLimite(String senha, double limite)

    /**
     * Retorna o valor disponível para saque dessa conta,
     * que é a soma do saldo com o limite.
     */
    double disponivel() {
        return this.saldo + this.limite;
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
