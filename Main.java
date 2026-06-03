public class Main {
    public static void main(String[] args) {
        GerenciadorFrota gerenciador = new GerenciadorFrota();

        // --- AÇÃO 1: Instanciar veículo com placa incorreta no try-catch ---
        System.out.println("=== Ação 1: Validação de Exceção ===");
        try {
            System.out.println("Tentando instanciar veículo com placa 'ABC12'...");
            // O erro vai ocorrer aqui, impedindo a criação do objeto
            Carro carroInvalido = new Carro("ABC12", 2000.0, 15000);
            System.out.println("Veículo criado! (Isso não deve aparecer)"); 
        } catch (PlacaInvalidaException e) {
            System.out.println("Exceção capturada com sucesso: " + e.getMessage());
        }

        // --- AÇÃO 2: Adicionar à frota objetos com dados válidos ---
        System.out.println("\n=== Ação 2: Adicionando Veículos Válidos ===");
        Carro carroValido = new Carro("ABC1234", 1500.0, 10000);
        Caminhao caminhaoValido = new Caminhao("XYZ9876", 5000.0, 15.5);
        
        gerenciador.adicionarVeiculo(carroValido);
        gerenciador.adicionarVeiculo(caminhaoValido);
        System.out.println("Carro e Caminhão válidos adicionados à frota em memória.");

        // --- AÇÃO 3: Gravação do estado da frota no arquivo "frota.txt" ---
        System.out.println("\n=== Ação 3: Gravando no Arquivo ===");
        String nomeArquivo = "frota.txt";
        gerenciador.salvarDadosEmArquivo(nomeArquivo);

        // --- AÇÃO 4: Carregamento e leitura retroativa do arquivo ---
        System.out.println("\n=== Ação 4: Lendo Arquivo Gerado ===");
        gerenciador.lerDadosDoArquivo(nomeArquivo);
    }
}