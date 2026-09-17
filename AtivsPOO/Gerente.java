public class Gerente extends Pessoa {

    String matricula, senha;

    Gerente()

    Gerente(
        String nome, Data nascimento, char sexo, String cpf, String matricula, String senha
    ) {
        super(nome, nascimento, sexo, cpf);
        this.matricula = matricula;
        this.senha = senha;
    }

    boolean validarAcesso()

    boolean validarAcesso(String s) {
        if (s.equals(this.senha)) {
            System.out.println("Senha correta!");
            return true;
        }
        System.out.println("Senha incorreta!");
        return false;
    }
}
