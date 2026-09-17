class Cofre {

    private String senha;
    int tentativasRestantes = 3;
    boolean aberto = false;

    public Cofre(String senha) {
        this.senha = senha;
    }

    public boolean abrir(String senha) {
        if (this.aberto) {
            System.out.println("Cofre já está aberto");
            return false;
        }
        else if (this.tentativasRestantes <= 0) {
            System.out.println("Tentativas se esgotaram; cofre trancado!");
            return false;
        }

        if (this.senha.equals(senha)) {
            System.out.println("Cofre aberto!");
            this.aberto = true;
        }
        else {
            System.out.println("Senha incorreta!");
            this.tentativasRestantes--;

            if (this.tentativasRestantes == 0) {
                System.out.println("Tentativas se esgotaram; cofre trancado!");
            }
        }

        return this.aberto;
    }

    public boolean fechar() {
        if (!this.aberto) {
            System.out.println("Cofre já está fechado");
            return false;       // Não funcionou
        }

        this.aberto = false;
        return true;        // Funcionou
    }

    public boolean alterarSenha(String novaSenha) {
        if (!this.aberto) {
            System.out.println("O cofre precisa estar aberto para poder alterar a senha");
            return false;
        }

        this.senha = novaSenha;
        return true;
    }
}