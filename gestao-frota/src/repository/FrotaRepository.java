package repository;

import model.Veiculo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FrotaRepository {
    private static final String NOME_ARQUIVO = "frota.txt";

    public void salvarDados(List<Veiculo> frota) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
            for (Veiculo v : frota) {
                String tipo = v.getClass().getSimpleName();
                String linha = String.format("Tipo: %s | Placa: %s | Custo Fixo: %.2f | Custo Total: %.2f",
                        tipo, v.getPlaca(), v.getCustoFixo(), v.calcularCustoTotal());
                
                bw.write(linha);
                bw.newLine();
            }
        }
    }

    public List<String> lerDadosSalvos() throws IOException {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }
        }
        return linhas;
    }
}