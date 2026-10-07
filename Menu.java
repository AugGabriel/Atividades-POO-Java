public class Menu {

    /**
     * Menu inicial do sistema. Opções de entrada:
     * <br>- 1. Cadastro;
     * <br>- 2. Movimentações financeiras;
    */
    public static char menuInicial() {
        System.out.println("O que deseja fazer?");
        System.out.println("1) Cadastro");
        System.out.println("2) Movimentações financeiras");
            
        return Leitor.proximoCaractere();
    }
    
    /**
     * Menu de cadastros do sistema. Opções de entrada:
     * <br>- a. Adicionar pessoa;
     * <br>- b. Adicionar gerente;
     * <br>- c. Criar conta corrente;
     * <br>- d. Criar poupança;
    */
    public static char menuCadastro() {
        System.out.println("a) Adicionar pessoa");
        System.out.println("b) Adicionar gerente");
        System.out.println("c) Criar conta corrente");
        System.out.println("d) Criar poupança");

        return Leitor.proximoCaractere();
    }

    /**
     * Menu de movimentações financeiras do sistema. Opções de entrada:
     * <br>- a. Verificar extrato;
     * <br>- b. Depositar;
     * <br>- c. Sacar;
     * <br>- d. Transferir;
    */
    public static char menuMovimentacao() {
        System.out.println("a) Verificar extrato");
        System.out.println("b) Depositar");
        System.out.println("c) Sacar");
        System.out.println("d) Transferir");

        return Leitor.proximoCaractere();
    }
}
