class Pessoa {

    private String nome, cpf;
    private char sexo;
    private Data nascimento;

    public Pessoa() {
        System.out.print("Informe o nome: ");
        this.nome = Leitor.proximaLinha();

        System.out.println("Informe a data de nascimento: ");
        this.nascimento = new Data();

        System.out.print("Informe o sexo: ");
        this.sexo = Leitor.primeiroCaractere();

        System.out.print("Informe o cpf: ");
        this.cpf = Leitor.primeiraPalavra();

        System.out.println("Nova pessoa criada no sistema.\n");   
    }
    
    public Pessoa(String nome, Data nascimento, char sexo, String cpf) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.cpf = cpf;
        System.out.println("Nova pessoa criada no sistema.\n");   
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public int idade(Data hoje) {
        int idade = hoje.getAno() - this.nascimento.getAno();

        Data aniversario = new Data(
            this.nascimento.getDia(), this.nascimento.getMes(), hoje.getAno()
        );

        if (hoje.maior(aniversario)) {
            return idade;
        }
        return idade - 1;
    }
}
