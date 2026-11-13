package excecoes;

public class EntradaInvalidaException extends Exception {
    
    private static String message = "\nEntrada inválida!\n";

    public String getMessage() { return message; }
}
