package view;

import controller.FrotaController;
import model.PlacaInvalidaException;

import java.io.IOException;
import java.util.List;

public class FrotaView {
    private FrotaController controller;

    public FrotaView() {
        this.controller = new FrotaController();
    }

    public void iniciarCenarioDeTestes() {
        System.out.println("=== SISTEMA DE GESTÃO DE FROTA (MVC) ===\n");

        System.out.println("-> Ação 1: Testando validação de placa");
        try {
            controller.adicionarCarro("ABC12", 2000.0, 15000);
        } catch (PlacaInvalidaException e) {
            System.err.println("[ERRO DE NEGÓCIO Capturado na View] " + e.getMessage());
        }

        System.out.println("\n-> Ação 2: Adicionando veículos válidos...");
        try {
            controller.adicionarCarro("ABC1234", 1500.0, 10000);
            controller.adicionarCaminhao("XYZ9876", 5000.0, 15.5);
            System.out.println("Veículos adicionados com sucesso à memória.");
        } catch (PlacaInvalidaException e) {
            System.err.println("Erro ao adicionar veículo: " + e.getMessage());
        }

        System.out.println("\n-> Ação 3: Salvando dados no repositório...");
        try {
            controller.persistirFrota();
            System.out.println("Arquivo 'frota.txt' gerado com sucesso pelo Repository!");
        } catch (IOException e) {
            System.err.println("[ERRO DE I/O] Falha ao gravar arquivo: " + e.getMessage());
        }

        System.out.println("\n-> Ação 4: Lendo dados persistidos...");
        try {
            List<String> dados = controller.carregarHistorico();
            for (String linha : dados) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.err.println("[ERRO DE I/O] Falha ao ler arquivo: " + e.getMessage());
        }
    }
}