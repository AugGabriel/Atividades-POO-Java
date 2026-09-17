public class Data {
    int dia, mes, ano;

    Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    boolean maior(Data d2) {
        if (d2.ano != this.ano) {
            return d2.ano > this.ano;
        }
        if (d2.mes != this.mes) {
            return d2.mes > this.mes;
        }
        return d2.dia > this.dia;
    }

    void imprimir() {
        System.out.println(this.dia + "/" + this.mes + "/" + this.ano);
    }
}
