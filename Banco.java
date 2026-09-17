class Banco {

    public static void main(String[] args) {
        Data data1 = new Data();
        Data data2 = new Data();

        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa();

        Gerente gerente1 = new Gerente();
        Gerente gerente2 = new Gerente();

        ContaCorrente contaCorrente1 = new ContaCorrente("1", pessoa1, data1, gerente1);
        ContaCorrente contaCorrente2 = new ContaCorrente("2", pessoa2, data2, gerente2);

        Poupanca poupanca1 = new Poupanca("1", pessoa1, data1, gerente1);
        Poupanca poupanca2 = new Poupanca("2", pessoa2, data2, gerente2);

        // Datas
        data1.imprimir();
        data2.imprimir();

        Data hoje = new Data(17, 9, 2026);
        System.out.println(pessoa1.idade(hoje));
        System.out.println(pessoa2.idade(hoje));
        System.out.println(gerente1.idade(hoje));
        System.out.println(gerente2.idade(hoje));

        // Transferências
        contaCorrente1.depositar(500);
        contaCorrente1.sacar(1000);
        contaCorrente1.transferir(700, poupanca2);

        for (int i = 0; i < 10; i++) {
            contaCorrente1.chequeEspecial(1);
            poupanca2.rendimentos(0.5);
        }

        contaCorrente1.alterarLimite("123456", 5000);
        System.out.println("Disponível na poupança 1: " + poupanca1.disponivel());
        poupanca1.transferir(-100, poupanca2);
        contaCorrente2.transferir(-200, poupanca2);

        // Extrato
        contaCorrente1.extrato();
        contaCorrente2.extrato();
        poupanca1.extrato();
        poupanca2.extrato();
    }
}
