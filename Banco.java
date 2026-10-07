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
                System.out.println("Opção inválida!");
            }
        }

        System.out.println("Até mais!");
        Leitor.fechar();
    }

    public static void cadastro() {
        entrada = Menu.menuCadastro();

        if (entrada == 'a') {
            pessoas.add(new Pessoa());
        }
        if (entrada == 'b') {
            gerentes.add(new Gerente());
        }
        if (entrada == 'c' || entrada == 'd') {
            if (gerentes.isEmpty()) {
                System.out.println("Cadastre um gerente primeiro!");
                return;
            }

            System.out.println("Escolha um gerente:");
            for (int i = 1; i <= gerentes.size() - 1; i++) {
                Gerente gerente = gerentes.get(i - 1);
                System.out.println(
                    i + ") " + gerente.getMatricula() + " - " + gerente.getNome()
                );
            }

            Gerente gerente = gerentes.get(Leitor.proximoInteiro() - 1);
            
            if (entrada == 'c') {
                contasCorrentes.add(new ContaCorrente(gerente));
            }
            else {
                poupancas.add(new Poupanca(gerente));
            }
        }
    }

    public static void movimentacao() {
        entrada = Menu.menuMovimentacao();
        boolean resultado = false;

        if (entrada == 'a' || entrada == 'b' || entrada == 'c') {
            Conta conta = obterContaEntrada("Selecione a conta: ");

            if (entrada == 'a') {
                conta.extrato();
                resultado = true;
            }
            else if (entrada == 'b') {
                System.out.println("Informe o valor para depositar: ");
                conta.depositar(Leitor.proximoInteiro());
                resultado = true;
            }
            else if (entrada == 'c') {
                System.out.println("Informe o valor para sacar: ");
                resultado = conta.sacar(Leitor.proximoInteiro());
            }
        }
        else if (entrada == 'd') {
            Conta remetente = obterContaEntrada("Selecione a conta remetente: ");
            Conta destinatario = obterContaEntrada("Selecione a conta destinatária: ");

            System.out.println("Informe o valor da transferência: ");
            resultado = remetente.transferir(Leitor.proximoDouble(), destinatario);
        }
        else {
            System.out.println("Entrada inválida!");
        }

        if (resultado) {
            System.out.println("Operação realizada com sucesso!");
        }
        else {
            System.out.println("Operação falhou!");
        }
    }
    
    private static Conta obterContaEntrada(String mensagem) {
        System.out.println(mensagem);
        mostrarContas();

        int index_resposta = Leitor.proximoInteiro() - 1;
        Conta conta;

        if (index_resposta <= contasCorrentes.size()) {
            conta = contasCorrentes.get(index_resposta);
        }
        else {
            conta = poupancas.get(index_resposta - contasCorrentes.size());
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
        