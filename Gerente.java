import java.util.Scanner;

public class Gerente extends Pessoa {

    String matricula, senha;

    Gerente() {
        super();

        Scanner leitor = new Scanner(System.in);

        System.out.println("Informe a matrícula: ");
        this.matricula = leitor.next();

        this.senha = "123456";
        System.out.println("Senha temporária: " + this.senha);

        leitor.close();
    }

    Gerente(
        String nome, Data nascimento, char sexo, String cpf, String matricula, String senha
    ) {
        super(nome, nascimento, sexo, cpf);
        this.matricula = matricula;
        this.senha = senha;
    }

    boolean validarAcesso(String s) {
        if (s.equals(this.senha)) {
            System.out.println("Senha correta!");
            return true;
        }
        System.out.println("Senha incorreta!");
        return false;
    }

    boolean validarAcesso() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite a senha: ");
        String senha = leitor.next();

        leitor.close();

        return this.validarAcesso(senha);
    }
}
