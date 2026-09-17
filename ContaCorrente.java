import java.util.Scanner;

public class ContaCorrente extends Conta {
    
    double limite;

    ContaCorrente(Gerente gerente) {
        super(gerente);
        this.limite = 200;
    }

    ContaCorrente(String numero, Pessoa titular, Data criacao, Gerente gerente) {
        super(numero, titular, criacao, gerente);
        this.limite = 200;
    }
    
    void alterarLimite() {
        if (this.gerente.validarAcesso()) {
            Scanner leitor = new Scanner(System.in);

            this.limite = leitor.nextDouble();

            leitor.close();
        }
    }

    void alterarLimite(String senha, double limite) {
        if (this.gerente.validarAcesso(senha)) {
            this.limite = limite;
        }
    }

    /**
     * Retorna o valor disponível para saque dessa conta,
     * que é a soma do saldo com o limite.
     */
    double disponivel() {
        return this.saldo + this.limite;
    }

    void extrato() {
        System.out.println(" *** EXTRATO DE CONTA-CORRENTE *** ");
        super.extrato();
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
