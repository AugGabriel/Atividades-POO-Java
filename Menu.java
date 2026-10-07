public class Menu {
    public static char menuInicial() {
        System.out.println("O que deseja fazer?");
        System.out.println("1) Cadastro");
        System.out.println("2) Movimentações financeiras");
            
        return Leitor.proximoCaractere();
    }
    
    public static char menuCadastro() {
        System.out.println("a) Adicionar pessoa");
        System.out.println("b) Adicionar gerente");
        System.out.println("c) Criar conta corrente");
        System.out.println("d) Criar poupança");

        return Leitor.proximoCaractere();
    }

    public static char menuMovimentacao() {
        System.out.println("a) Verificar extrato");
        System.out.println("b) Depositar");
        System.out.println("c) Sacar");
        System.out.println("d) Transferir");

        return Leitor.proximoCaractere();
    }
}
