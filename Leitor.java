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

    public static int proximoInteiro() {
        return leitor.nextInt();
    }

    public static void fechar() {
        leitor.close();
    }
}
