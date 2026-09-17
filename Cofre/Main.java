import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Informe a senha do cofre:");
        Cofre cofre = new Cofre(leitor.nextLine());

        System.out.println("Agora tente abrir o cofre:");
        while (!cofre.aberto) {
            cofre.abrir(leitor.nextLine());
        }
        
        leitor.close();
    }
}