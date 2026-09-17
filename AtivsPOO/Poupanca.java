public class Poupanca extends Conta {
    
    /**
     * Imprime os dados da conta
     */
    void extrato() {
        System.out.println(" *** EXTRATO DA CONTA *** ");
        System.out.println("Conta: " + this.numero);
        System.out.println("Titular: " + this.titular.nome);
        System.out.printf("Valor disponivel para saque : R$%.2f\n", this.disponivel());
    }

    void rendimentos(double juro) {
        this.saldo *= 1 + (juro / 100);
    }
}
