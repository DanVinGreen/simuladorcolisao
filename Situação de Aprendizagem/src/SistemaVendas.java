
import java.util.Scanner;

public class SistemaVendas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Passo 1: Solicitar o número de vendedores
        System.out.print("Digite o numero de vendedores: ");
        int numVendedores = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        // Passo 1: Criar arrays para armazenar os dados
        String[] nomes = new String[numVendedores];
        double[][] vendas = new double[numVendedores][5]; // 5 dias úteis
        double[] totais = new double[numVendedores];
        String[] classificacao = new String[numVendedores];
        double[] bonus = new double[numVendedores];

        // Passo 2: Solicitar os nomes dos vendedores
        for (int i = 0; i < numVendedores; i++) {
            System.out.print("Digite o nome do vendedor " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();
        }

        // Passo 3: Registrar as vendas
        for (int i = 0; i < numVendedores; i++) {
            System.out.println("Digite as vendas de " + nomes[i] + " para os 5 dias uteis:");
            for (int j = 0; j < 5; j++) {
                System.out.print("Venda do dia " + (j + 1) + ": R$ ");
                vendas[i][j] = scanner.nextDouble();
            }
        }

        // Passo 4: Calcular totais e classificações
        double maiorTotal = 0;
        String melhorVendedor = "";

        for (int i = 0; i < numVendedores; i++) {
            for (int j = 0; j < 5; j++) {
                totais[i] += vendas[i][j];
            }

            // Classificação e bonificação
            if (totais[i] >= 5000) {
                classificacao[i] = "Excelente";
                bonus[i] = totais[i] * 0.10;
            } else if (totais[i] >= 3000) {
                classificacao[i] = "Bom";
                bonus[i] = totais[i] * 0.05;
            } else {
                classificacao[i] = "Regular";
                bonus[i] = 0;
            }

            // Verificar o melhor vendedor
            if (totais[i] > maiorTotal) {
                maiorTotal = totais[i];
                melhorVendedor = nomes[i];
            }
        }

        // Passo 7: Gerar relatório
        System.out.println("============================================================");
        System.out.println("RELATORIO DE VENDAS SEMANAIS");
        System.out.println("============================================================");
        System.out.printf("| %-16s | R$ %10s | %-13s | R$ %8s |\n", "Vendedor", "Total Vendido", "Classificacao", "Bonus");
        System.out.println("+-----------------------------------------------------------------------------+");

        for (int i = 0; i < numVendedores; i++) {
            System.out.printf("| %-16s | R$ %10.2f | %-13s | R$ %8.2f |\n", 
                nomes[i], totais[i], classificacao[i], bonus[i]);
        }
        
        System.out.println("+-----------------------------------------------------------------------------+");
        System.out.printf("MELHOR VENDEDOR DA SEMANA: %s (R$ %.2f)\n", melhorVendedor, maiorTotal);
        System.out.println("============================================================");
        
        scanner.close();
    }
}
