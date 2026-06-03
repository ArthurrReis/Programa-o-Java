public class Main {
    public static void main(String[] args) {
        GerenciadorFrota gerenciador = new GerenciadorFrota();

        System.out.println("=== Ação 1: Validação de Exceção ===");
        try {
            System.out.println("Tentando instanciar veículo com placa 'ABC12'...");
            Carro carroInvalido = new Carro("ABC12", 2000.0, 15000);
            System.out.println("Veículo criado! (Isso não deve aparecer)"); 
        } catch (PlacaInvalidaException e) {
            System.out.println("Exceção capturada com sucesso: " + e.getMessage());
        }

        System.out.println("\n=== Ação 2: Adicionando Veículos Válidos ===");
        Carro carroValido = new Carro("ABC1234", 1500.0, 10000);
        Caminhao caminhaoValido = new Caminhao("XYZ9876", 5000.0, 15.5);
        
        gerenciador.adicionarVeiculo(carroValido);
        gerenciador.adicionarVeiculo(caminhaoValido);
        System.out.println("Carro e Caminhão válidos adicionados à frota em memória.");

        System.out.println("\n=== Ação 3: Gravando no Arquivo ===");
        String nomeArquivo = "frota.txt";
        gerenciador.salvarDadosEmArquivo(nomeArquivo);

        System.out.println("\n=== Ação 4: Lendo Arquivo Gerado ===");
        gerenciador.lerDadosDoArquivo(nomeArquivo);
    }
}
