import java.util.ArrayList;

import excecoes.EntradaInvalidaException;
import excecoes.EscolhaInvalidaException;

class Banco {

    private static ArrayList<Pessoa> pessoas = new ArrayList<>();
    private static ArrayList<Gerente> gerentes = new ArrayList<>();
    private static ArrayList<ContaCorrente> contasCorrentes = new ArrayList<>();
    private static ArrayList<Poupanca> poupancas = new ArrayList<>();

    private static char entrada = ' ';

    /**
     * Função principal do programa. 
     * 
     * Continuamente lê entrada do usuário, até que ele decida sair, e permite que ele efetue cadastros e movimentações.
     */
    public static void main(String[] args) {

        System.out.println("Bem vindo!");

        while (entrada != '0') {
            entrada = Menu.menuInicial();
            
            try {
            if (entrada == '1') {
                cadastro();
            }
            else if (entrada == '2') {
                movimentacao();
            }
            else if (entrada != '0') {
                    throw new EscolhaInvalidaException();
                }
            }
            catch (EntradaInvalidaException | EscolhaInvalidaException exc) {
                System.out.println(exc.getMessage());
            }
        }

        System.out.println("\nAté mais!");
        Leitor.fechar();
    }

    /**
     * Menu de cadastros do sistema. 
     * 
     * Permite que o usuário cadastre clientes, gerentes, contas correntes e poupanças.
     */
    public static void cadastro() throws EntradaInvalidaException {
        entrada = Menu.menuCadastro();

        if (entrada == 'a') {
            pessoas.add(new Pessoa());
        }
        else if (entrada == 'b') {
            Gerente gerente = new Gerente();
            gerentes.add(gerente);
            pessoas.add(gerente);
        }
        else if (entrada == 'c' || entrada == 'd') {
            cadastrarConta();
        }

        else {
            throw new EntradaInvalidaException();
        }
    }

    /**
     * Menu de movimentações do sistema.
     * 
     * Permite que o usuário efetue movimentações financeiras entre contas do sistema.
     */
    public static void movimentacao() throws EntradaInvalidaException {
        // Validação de pré-requisitos
        int numeroContas = contasCorrentes.size() + poupancas.size();
        if (numeroContas == 0) {
            System.out.println("\nCadastre uma conta antes de realizar movimentações!\n");
            return;
        }

        // Declaração de variáveis
        entrada = Menu.menuMovimentacao();
        boolean resultado = false;

        // Lógica
        if (entrada == 'a' || entrada == 'b' || entrada == 'c') {
            resultado = movimentacaoUmaConta();
        }
        else if (entrada == 'd') {
            resultado = movimentacaoTransferencia(numeroContas);
        }
        else {
            throw new EntradaInvalidaException();
        }

        if (resultado) {
            System.out.println("\nOperação realizada com sucesso!\n");
        }
        else {
            System.out.println("\nOperação falhou!\n");
        }
    }

    /**
     * Cadastro de conta. Permite que o usuário crie contas dos tipos corrente e poupança.
     */
    private static void cadastrarConta() {
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
        for (int i = 1; i <= gerentes.size(); i++) {
            Gerente gerente = gerentes.get(i - 1);
            System.out.println(
                i + ") " + gerente.getMatricula() + " - " + gerente.getNome()
            );
        }
    
        int escolhaGerente;
        try {
            escolhaGerente = Leitor.proximoInteiro() - 1;
        }
        catch (NumberFormatException exc) {
            System.out.println("\nEntrada inválida!\n");
            return;
        }
        if (escolhaGerente >= gerentes.size()) {
            System.out.println("\nEscolha inválida\n");
            return;
        }
        Gerente gerente = gerentes.get(escolhaGerente);

        // Escolha da pessoa
        System.out.println("Escolha uma pessoa:");
        for (int i = 1; i <= pessoas.size(); i++) {
            Pessoa pessoa = pessoas.get(i - 1);
            System.out.println(
                i + ") " + pessoa.getCpf() + " - " + pessoa.getNome()
            );
        }

        int escolhaPessoa;
        try {
            escolhaPessoa = Leitor.proximoInteiro() - 1;
        }
        catch (NumberFormatException exc) {
            System.out.println("\nEntrada inválida!\n");
            return;
        }            
        if (escolhaPessoa >= pessoas.size()) {
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
    
    /**
     * Lista todas as contas do sistema numeradas, e pede para o usuário escolher uma.
     * Se a escolha estiver entre as contas listadas, esta é retornada.
     * Senão, uma mensagem é mostrada ao usuário, e nulo é retornado.
     */
    private static Conta obterContaEntrada(String mensagem) throws NumberFormatException {
        System.out.println(mensagem);
        mostrarContas();

        int index_resposta = Leitor.proximoInteiro() - 1;
        Conta conta;

        if (index_resposta < contasCorrentes.size()) {
            conta = contasCorrentes.get(index_resposta);
        }
        else if (index_resposta < contasCorrentes.size() + poupancas.size()) {
            conta = poupancas.get(index_resposta - contasCorrentes.size());
        }
        else {
            System.out.println("\nConta inválida!\n");
            return null;
        }

        return conta;
    }

    /**
     * Imprime todas as contas do banco.
     * 
     * As contas são indexadas sequencialmente, começando pelas contas corrente e continuando com as poupança.
     */
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

    private static void movimentacaoUmaConta() throws EntradaInvalidaException, EscolhaInvalidaException {
        Conta conta = obterContaEntrada("Selecione a conta: ");

        try {
            // Extrato
        if (entrada == 'a') {
            conta.extrato();
        }

            // Depósito
        else if (entrada == 'b') {
            System.out.println("Informe o valor para depositar: ");

                conta.depositar(Leitor.proximoDouble());
                System.out.println("\nDepósito realizado com sucesso!\n");
            }

            // Saque
        else if (entrada == 'c') {
            System.out.println("Informe o valor para sacar: ");

                conta.sacar(Leitor.proximoDouble());
                System.out.println("\nSaque realizado com sucesso!\n");
            }
            }
            catch (NumberFormatException exc) {
            throw new EntradaInvalidaException();
        }
    }

    private static void movimentacaoTransferencia(int numeroContas) 
        throws EntradaInvalidaException, OperacaoFalhouException, EscolhaInvalidaException
    {
        // Validação dos pré-requisitos
        if (numeroContas < 2) {
            throw new OperacaoFalhouException(
                "\nHá apenas uma conta cadastrada no sistema, e não é possível realizar"
                + " a transferência!\n"
            );
        }

        // Escolha da conta remetente
        Conta remetente;
        try {
            remetente = obterContaEntrada("\"Selecione a conta remetente: ");
        }
        catch (NumberFormatException exc) {
            throw new EntradaInvalidaException();
        }

        // Escolha da conta destinatária
        Conta destinatario;
        try {
            destinatario = obterContaEntrada("\"Selecione a conta destinatária: ");
        }
        catch (NumberFormatException exc) {
            throw new EntradaInvalidaException();
        }

        // Operação
        System.out.println("Informe o valor da transferência: ");

        try {
            remetente.transferir(Leitor.proximoDouble(), destinatario);
        }
        catch (NumberFormatException exc) {
            throw new EntradaInvalidaException();
        }

        System.out.println("\nTransferência realizada com sucesso!\n");
    }
}
        