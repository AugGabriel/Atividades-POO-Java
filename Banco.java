import java.util.ArrayList;

class Banco {

    private static ArrayList<Pessoa> pessoas = new ArrayList<>();
    private static ArrayList<Gerente> gerentes = new ArrayList<>();
    private static ArrayList<ContaCorrente> contasCorrentes = new ArrayList<>();
    private static ArrayList<Poupanca> poupancas = new ArrayList<>();

    private static char entrada = ' ';

    public static void main(String[] args) {

        System.out.println("Bem vindo!");

        while (entrada != '0') {
            entrada = Menu.menuInicial();
            
            if (entrada == '1') {
                cadastro();
            }
            else if (entrada == '2') {
                movimentacao();
            }
            else if (entrada != '0') {
                System.out.println("\nOpção inválida!\n");
            }
        }

        System.out.println("\nAté mais!");
        Leitor.fechar();
    }

    public static void cadastro() {
        entrada = Menu.menuCadastro();

        if (entrada == 'a') {
            pessoas.add(new Pessoa());
        }
        else if (entrada == 'b') {
            gerentes.add(new Gerente());
        }
        else if (entrada == 'c' || entrada == 'd') {
            // Validações
            if (gerentes.isEmpty()) {
                System.out.println("\nCadastre um gerente primeiro!\n");
                return;
            }
            if (pessoas.isEmpty()) {
                System.out.println("Cadastre uma pessoa primeiro!\n");
                return;
            }

            // Escolha do gerente
            System.out.println("Escolha um gerente:");
            for (int i = 1; i <= gerentes.size() - 1; i++) {
                Gerente gerente = gerentes.get(i - 1);
                System.out.println(
                    i + ") " + gerente.getMatricula() + " - " + gerente.getNome()
                );
            }

            int escolhaGerente = Leitor.proximoInteiro() - 1;
            if (escolhaGerente > gerentes.size()) {
                System.out.println("\nEscolha inválida\n");
                return;
            }
            Gerente gerente = gerentes.get(escolhaGerente);

            // Escolha da pessoa
            System.out.println("Escolha uma pessoa:");
            for (int i = 1; i <= pessoas.size() - 1; i++) {
                Pessoa pessoa = pessoas.get(i - 1);
                System.out.println(
                    i + ") " + pessoa.getCpf() + " - " + pessoa.getNome()
                );
            }

            int escolhaPessoa = Leitor.proximoInteiro() - 1;
            if (escolhaPessoa > pessoas.size()) {
                System.out.println("\nEscolha inválida!\n");
                return;
            }
            Pessoa titular = pessoas.get(escolhaPessoa);
            
            // Menus
            if (entrada == 'c') {
                contasCorrentes.add(new ContaCorrente(gerente, titular));
            }
            else {
                poupancas.add(new Poupanca(gerente, titular));
            }
        }

        else {
            System.out.println("\nEntrada inválida!\n");
            return;
        }
    }

    public static void movimentacao() {
        int numeroContas = contasCorrentes.size() + poupancas.size();
        if (numeroContas == 0) {
            System.out.println("\nCadastre uma conta antes de realizar movimentações!\n");
            return;
        }

        entrada = Menu.menuMovimentacao();
        boolean resultado = false;

        if (entrada == 'a' || entrada == 'b' || entrada == 'c') {
            Conta conta = obterContaEntrada("Selecione a conta: ");
            if (conta == null) {
                return;
            }

            if (entrada == 'a') {
                conta.extrato();
                resultado = true;
            }
            else if (entrada == 'b') {
                System.out.println("Informe o valor para depositar: ");
                resultado = conta.depositar(Leitor.proximoInteiro());
            }
            else if (entrada == 'c') {
                System.out.println("Informe o valor para sacar: ");
                resultado = conta.sacar(Leitor.proximoInteiro());
            }
        }

        else if (entrada == 'd') {
            if (numeroContas < 2) {
                System.out.println(
                    "\nHá apenas uma conta cadastrada no sistema, e não é possível realizar transferência!\n"
                );
                return;
            }

            Conta remetente = obterContaEntrada("Selecione a conta remetente: ");
            if (remetente == null) { return; }
            Conta destinatario = obterContaEntrada("Selecione a conta destinatária: ");
            if (destinatario == null) { return; }

            System.out.println("Informe o valor da transferência: ");
            resultado = remetente.transferir(Leitor.proximoDouble(), destinatario);
        }
        
        else {
            System.out.println("\nEntrada inválida!\n");
            return;
        }

        if (resultado) {
            System.out.println("\nOperação realizada com sucesso!\n");
        }
        else {
            System.out.println("\nOperação falhou!\n");
        }
    }
    
    /**
     * Lista todas as contas do sistema numeradas, e pede para o usuário escolher uma.
     * Se a escolha estiver entre as contas listadas, esta é retornada.
     * Senão, uma mensagem é mostrada ao usuário, e nulo é retornado.
     */
    private static Conta obterContaEntrada(String mensagem) {
        System.out.println(mensagem);
        mostrarContas();

        int index_resposta = Leitor.proximoInteiro() - 1;
        Conta conta;

        if (index_resposta <= contasCorrentes.size()) {
            conta = contasCorrentes.get(index_resposta);
        }
        else if (index_resposta <= contasCorrentes.size() + poupancas.size()) {
            conta = poupancas.get(index_resposta - contasCorrentes.size());
        }
        else {
            System.out.println("\nConta inválida!\n");
            return null;
        }

        return conta;
    }

    private static void mostrarContas() {
        int index_resposta = 0;

        System.out.println("Contas correntes: ");
        for (int i = 0; i < contasCorrentes.size(); i++) {
            index_resposta++;

            ContaCorrente conta = contasCorrentes.get(i);
            System.out.println(index_resposta + ") " + conta.numero);
        }

        System.out.println("\nContas poupança: ");
        for (int i = 0; i < poupancas.size(); i++) {
            index_resposta++;

            Poupanca conta = poupancas.get(i);
            System.out.println(index_resposta + ") " + conta.numero);
        }

    }
}
        