import java.util.Scanner;

public class Leitor {
    private static Scanner leitor = new Scanner(System.in);

    public static char menuInicial() {
        System.out.println("O que deseja fazer?");
        System.out.println("1) Cadastro");
        System.out.println("2) Movimentações financeiras");
            
        return leitor.next().charAt(0);
    }
    
    public static char menuCadastro() {
        System.out.println("a) Adicionar pessoa");
        System.out.println("b) Adicionar gerente");
        System.out.println("c) Criar conta corrente");
        System.out.println("d) Criar poupança");

        return leitor.next().charAt(0);
    }

    public static char menuMovimentacao() {
        System.out.println("a) Verificar extrato");
        System.out.println("b) Depositar");
        System.out.println("c) Sacar");
        System.out.println("d) Transferir");

        return leitor.next().charAt(0);
    }

    public static String proximaLinha() {
        return leitor.nextLine();
    }

    public static String proximaPalavra() {
        return leitor.next();
    }

    public static char proximoCaractere() {
        return leitor.next().charAt(0);
    }

    public static void fechar() {
        leitor.close();
    }
}
