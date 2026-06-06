package controller;

import model.Caminhao;
import model.Carro;
import model.Veiculo;
import repository.FrotaRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FrotaController {
    private List<Veiculo> frotaAtiva;
    private FrotaRepository repository;

    public FrotaController() {
        this.frotaAtiva = new ArrayList<>();
        this.repository = new FrotaRepository();
    }

    public void adicionarCarro(String placa, double custoFixo, int quilometragem) {
        Carro carro = new Carro(placa, custoFixo, quilometragem); 
        frotaAtiva.add(carro);
    }

    public void adicionarCaminhao(String placa, double custoFixo, double toneladas) {
        Caminhao caminhao = new Caminhao(placa, custoFixo, toneladas); 
        frotaAtiva.add(caminhao);
    }

    public List<Veiculo> getFrotaAtiva() {
        return Collections.unmodifiableList(frotaAtiva); 
    }

    public void persistirFrota() throws IOException {
        repository.salvarDados(frotaAtiva);
    }

    public List<String> carregarHistorico() throws IOException {
        return repository.lerDadosSalvos();
    }
}