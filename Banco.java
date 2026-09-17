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
    }
}
