import java.util.Scanner;

public class Leitor {
    private static Scanner leitor = new Scanner(System.in);

    public static String proximaLinha() {
        return leitor.nextLine();
    }

    /**
     * Lê uma linha inteira e retorna apenas a primeira palavra.
     */
    public static String primeiraPalavra() {
        return leitor.nextLine().substring(0, 1);
    }

    /**
     * Lê uma linha inteira e retorna apenas o primeiro caractere
     */
    public static char primeiroCaractere() {
        return leitor.nextLine().charAt(0);
    }

    /**
     * Interface para o `nextDouble`, porém consome o enter que fica no buffer de entrada.
     */
    public static double proximoDouble() {
        double entrada = leitor.nextDouble();
        leitor.nextLine();
        return entrada;
    }

    /**
     * Interface para o `nextInt`, porém consome o enter que fica no buffer de entrada.
     */
    public static int proximoInteiro() {
        int entrada = leitor.nextInt();
        leitor.nextLine();
        return entrada;
    }

    public static void fechar() {
        leitor.close();
    }
}
