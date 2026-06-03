public class Carro extends Veiculo implements Tributavel{
    private int quilometragem;
    
    public Carro(String placa,Double custoFixo, int quilometragem){
        super(placa, custoFixo);
        this.quilometragem = quilometragem;
    }
    
    
    @Override
    public double calcularCustoTotal() {
        return getcustoFixo = custoFixo + (this.quilometragem * 0.15);
    }
    @Override
    public double calcularIPVA(){
        return getcustoFixo() * 0.04;
    }
    public int getquilometragem(){
        return quilometragem;
    }
    public void setquilometragem(int quilometragem){
        this.quilometragem = quilometragem;
    }
}
