class Pessoa {

    String nome, cpf;
    char sexo;
    Data dtNasc;
    
    Pessoa(String nome, Data dtNasc, char sexo, String cpf) {
        this.nome = nome;
        this.dtNasc = dtNasc;
        this.sexo = sexo;
        this.cpf = cpf;
        System.out.println("Nova pessoa criada no sistema.");
    }

    void alteraCPF(String cpf) {
        this.cpf = cpf;
    }

    int consultaIdade(Data hoje) {
        int idade = hoje.ano - this.dtNasc.ano;

        Data aniversario = new Data(
            this.dtNasc.dia, this.dtNasc.mes, hoje.ano
        );

        if (hoje.maior(aniversario)) {
            return idade;
        }
        return idade - 1;
    }
}
