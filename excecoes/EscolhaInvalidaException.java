package excecoes;

public class EscolhaInvalidaException extends Exception {

    private static String message = "\nEscolha inválida!\n";

    public String getMessage() { return message; }
}
