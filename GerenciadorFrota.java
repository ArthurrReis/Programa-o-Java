import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorFrota {
    private List<Veiculo> frota = new ArrayList<>();

    public void adicionarVeiculo(Veiculo v) {
        if (v != null) {
            frota.add(v);
        }
    }

    public void salvarDadosEmArquivo(String nomeArquivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Veiculo v : frota) {
                String tipo = v.getClass().getSimpleName();
                String linha = String.format("Tipo: %s | Placa: %s | Custo Fixo: %.2f | Custo Total: %.2f | IPVA: %.2f",
                        tipo, 
                        v.getPlaca(), 
                        v.getCustoFixo(), 
                        v.calcularCustoTotal(),
                        ((Tributavel) v).calcularIPVA());
                
                bw.write(linha);
                bw.newLine();
            }
            System.out.println("Dados salvos com sucesso no arquivo: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    public void lerDadosDoArquivo(String nomeArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            System.out.println("\n--- Lendo Dados do Arquivo ---");
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
            System.out.println("------------------------------");
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}