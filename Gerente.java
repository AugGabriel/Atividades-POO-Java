import java.util.Scanner;

public class Gerente extends Pessoa {

    private String matricula, senha;

    public Gerente() {
        super();

        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe a matrícula: ");
        this.matricula = leitor.next();

        this.senha = "123456";
        System.out.print("Senha temporária: " + this.senha);

        System.out.println();
    }

    public Gerente(
        String nome, Data nascimento, char sexo, String cpf, String matricula, String senha
    ) {
        super(nome, nascimento, sexo, cpf);
        this.matricula = matricula;
        this.senha = senha;
    }

    public boolean validarAcesso(String s) {
        if (s.equals(this.senha)) {
            System.out.println("Senha correta!");
            return true;
        }
        System.out.println("Senha incorreta!");
        return false;
    }

    public boolean validarAcesso() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite a senha: ");
        String senha = leitor.next();

        return this.validarAcesso(senha);
    }

    public boolean alterarSenha(String atual, String nova) {
        if (this.validarAcesso(atual)) {
            this.senha = nova;
            return true;
        }
        return false;
    }
}
