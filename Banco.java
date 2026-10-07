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
            for (int i = 1; i < gerentes.size() - 1; i++) {
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

        if (entrada == 'a') {}
        if (entrada == 'b') {}
        if (entrada == 'c') {}
        if (entrada == 'd') {}
    }
}
        