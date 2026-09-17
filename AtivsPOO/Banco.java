class Banco {

    public static void main(String[] args) {
        // Datas
        Data dG = new Data(14, 12, 2007);
        Data dL = new Data(11, 8, 2011);
        Data dGerente = new Data(1, 1, 1990);
        Data hoje = new Data(10, 9, 2026);

        // Pessoas
        Pessoa gabriel = new Pessoa("Gabriel", dG, 'M', "13246579891");
        Pessoa lucas = new Pessoa("Lucas", dL, 'M', "12345678991");
        Gerente gerente = new Gerente("Luzia", dGerente, 'F', "98765432191", "7", "senha");

        // Contas
        ContaCorrente contaGabriel = new ContaCorrente("123", gabriel, gerente, dG);
        Poupanca contaLucas = new Poupanca("123", lucas, gerente, dL);
    
        // Operações monetárias
        contaGabriel.depositar(2000);
        contaLucas.depositar(500);
        contaGabriel.transferir(1000, contaLucas);
        contaGabriel.transferir(1200, contaLucas);
        contaLucas.transferir(3000, contaGabriel);

        for (int i = 0; i < 10; i++) {
            contaGabriel.chequeEspecial(15);
        }
        for (int i = 0; i < 12; i++) {
            contaLucas.rendimentos(1);
        }

        // Operações com a senha do gerente
        gerente.validarAcesso("nao senha");
        gerente.validarAcesso("senha");

        // Operações com data
        contaGabriel.titular.dtNasc.imprimir();
        contaLucas.titular.dtNasc.imprimir();
        gerente.dtNasc.imprimir();

        gabriel.consultaIdade(hoje);
        lucas.consultaIdade(hoje);
        gerente.consultaIdade(hoje);

        // Extrato das contas
        contaGabriel.extrato();
        contaLucas.extrato();
    }
}
