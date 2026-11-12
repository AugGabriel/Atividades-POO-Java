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
     * Lê um número real da entrada do usuário, porém consome o enter que fica no buffer.
     * Lança `NumberFormatException` se a entrada não for conversível para um número.
     */
    public static double proximoDouble() throws NumberFormatException {
        return Double.parseDouble(leitor.nextLine());
    }

    /**
     * Lê um número inteiro da entrada do usuário, porém consome o enter que fica no buffer.
     * Lança `NumberFormatException` se a entrada não for conversível para um inteiro.
     */
    public static int proximoInteiro() throws NumberFormatException {
        return Integer.parseInt(leitor.nextLine());
    }

    public static void fechar() {
        leitor.close();
    }
}
