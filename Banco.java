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
            entrada = Leitor.menuInicial();
            
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
        entrada = Leitor.menuCadastro();

        if (entrada == 'a') {
            pessoas.add(new Pessoa());
        }
        if (entrada == 'b') {
            gerentes.add(new Gerente());
        }
        if (entrada == 'c') {}
        if (entrada == 'd') {}
    }

    public static void movimentacao() {
        entrada = Leitor.menuMovimentacao();

        if (entrada == 'a') {}
        if (entrada == 'b') {}
        if (entrada == 'c') {}
        if (entrada == 'd') {}
    }
}
        