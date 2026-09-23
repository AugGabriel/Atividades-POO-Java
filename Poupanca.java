public class Poupanca extends Conta {

    public Poupanca(Gerente gerente) {
        super(gerente);
    } 

    public Poupanca(String numero, Pessoa titular, Data criacao, Gerente gerente) {
        super(numero, titular, criacao, gerente);
    }

    public void extrato() {
        System.out.println(" *** EXTRATO DE POUPANCA *** ");
        super.extrato();
    }

    public void rendimentos(double juro) {
        this.saldo *= 1 + (juro / 100);
    }
}
