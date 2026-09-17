public class Poupanca extends Conta {

    Poupanca(Gerente gerente) {
        super(gerente);
    } 

    Poupanca(String numero, Pessoa titular, Data criacao, Gerente gerente) {
        super(numero, titular, criacao, gerente);
    }

    void extrato() {
        System.out.println(" *** EXTRATO DE POUPANCA *** ");
        super.extrato();
    }

    void rendimentos(double juro) {
        this.saldo *= 1 + (juro / 100);
    }
}
