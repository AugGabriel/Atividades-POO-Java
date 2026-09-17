class Pessoa {

    String nome, cpf;
    char sexo;
    Data nascimento;

    Pessoa()
    
    Pessoa(String nome, Data nascimento, char sexo, String cpf) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.cpf = cpf;
        System.out.println("Nova pessoa criada no sistema.");   
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
