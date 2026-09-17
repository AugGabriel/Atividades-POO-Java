import java.util.Scanner;

class Pessoa {

    String nome, cpf;
    char sexo;
    Data nascimento;

    Pessoa() {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe o nome: ");
        this.nome = leitor.nextLine();

        System.out.println("Informe a data de nascimento: ");
        this.nascimento = new Data();

        System.out.print("Informe o sexo: ");
        this.sexo = leitor.next().charAt(0);

        System.out.print("Informe o cpf: ");
        this.cpf = leitor.next();

        System.out.println("Nova pessoa criada no sistema.\n");   
    }
    
    Pessoa(String nome, Data nascimento, char sexo, String cpf) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.cpf = cpf;
        System.out.println("Nova pessoa criada no sistema.\n");   
    }

    int idade(Data hoje) {
        int idade = hoje.ano - this.nascimento.ano;

        Data aniversario = new Data(
            this.nascimento.dia, this.nascimento.mes, hoje.ano
        );

        if (hoje.maior(aniversario)) {
            return idade;
        }
        return idade - 1;
    }
}
