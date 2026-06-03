// Classe Abstrata Base
public abstract class Veiculo {
    private String placa;
    private double custoFixo;


public Veiculo(String placa, double custoFixo) {
// Validar placa (deve conter exatamente 7 caracteres)
    if (placa == null || placa.length() != 7){
        throw new IllegalArgumentException ("A placa deve conter 7 números!")
}

// Inicializar atributos
    this.placa = placa;
    this.custoFixo = custoFixo;
}
public abstract double calcularCustoTotal();
// Getters e Setters...
public String getplaca(){
    return placa;
}

public void setplaca(String placa){
    this.placa = placa;
}
public Double getcustoFixo(){
    return custoFixo;
}
public void setplaca(Double custoFixo){
    this.custoFixo = custoFixo;

}
}
