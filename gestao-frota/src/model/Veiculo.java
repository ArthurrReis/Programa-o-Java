package model;

public abstract class Veiculo {
    private String placa;
    private double custoFixo;

    public Veiculo(String placa, double custoFixo) {
        if (placa == null || placa.length() != 7) {
            throw new PlacaInvalidaException("Erro: A placa informada diverge de 7 caracteres.");
        }
        this.placa = placa;
        this.custoFixo = custoFixo;
    }

    public abstract double calcularCustoTotal();

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getCustoFixo() {
        return custoFixo;
    }

    public void setCustoFixo(double custoFixo) {
        this.custoFixo = custoFixo;
    }
}