public class Data {
    
    private int dia, mes, ano;

    public Data() {

        System.out.print("\tDigite o dia: ");
        this.dia = Leitor.proximoInteiro();

        System.out.print("\tDigite o mês: ");
        this.mes = Leitor.proximoInteiro();
        
        System.out.print("\tDigite o ano: ");
        this.ano = Leitor.proximoInteiro();

        System.out.println();
    }

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() { return this.dia; }
    public int getMes() { return this.mes; }
    public int getAno() { return this.ano; }

    public boolean maior(Data d2) {
        if (d2.ano != this.ano) {
            return d2.ano > this.ano;
        }
        if (d2.mes != this.mes) {
            return d2.mes > this.mes;
        }
        return d2.dia > this.dia;
    }

    public void imprimir() {
        System.out.println(this.dia + "/" + this.mes + "/" + this.ano);
    }
}
