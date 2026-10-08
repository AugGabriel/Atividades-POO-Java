public class Gerente extends Pessoa {

    private String matricula, senha;

    public Gerente() {
        super();

        System.out.print("Informe a matrícula: ");
        this.matricula = Leitor.primeiraPalavra();

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

    public String getMatricula() { return matricula; }

    public boolean validarAcesso(String s) {
        if (s.equals(this.senha)) {
            System.out.println("\nSenha correta!\n");
            return true;
        }
        System.out.println("\nSenha incorreta!\n");
        return false;
    }

    public boolean validarAcesso() {
        System.out.println("Digite a senha: ");
        String senha = Leitor.primeiraPalavra();

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
