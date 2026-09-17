public class Poupanca extends Conta {

    void extrato() {
        System.out.println(" *** EXTRATO DE POUPANCA *** ");
        super.extrato();
    }

    void rendimentos(double juro) {
        this.saldo *= 1 + (juro / 100);
    }
}
