import java.util.Scanner;

public class Leitor {
    private static Scanner leitor = new Scanner(System.in);

    public static String proximaLinha() {
        return leitor.nextLine();
    }

    public static String proximaPalavra() {
        return leitor.next();
    }

    public static char proximoCaractere() {
        return leitor.next().charAt(0);
    }

    public static double proximoDouble() {
        return leitor.nextDouble();
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
