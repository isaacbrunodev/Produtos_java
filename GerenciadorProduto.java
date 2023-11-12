import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GerenciadorProduto {

    private static final List<Produto> produtos = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        exibirMenu();
    }

    private static void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n*** Gerenciador de Produtos ***");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Exibir Produtos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opcao: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha pendente
                processarOpcao(opcao);
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um número válido.");
                scanner.nextLine(); // Consumir a entrada inválida
                opcao = 0; // Definir opção para 0 para repetir o loop
            }
        } while (opcao != 3);

        System.out.println("Obrigado por usar o Gerenciador de Produtos!");
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarProduto();
                break;
            case 2:
                exibirProdutos();
                break;
            case 3:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void adicionarProduto() {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preco do produto: ");
        double preco = scanner.nextDouble();

        Produto produto = new Produto(nome, preco);
        produtos.add(produto);

        System.out.println("Produto adicionado com sucesso!");
    }

    private static void exibirProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado ainda.");
        } else {
            System.out.println("\nLista de Produtos:");
            for (int i = 0; i < produtos.size(); i++) {
                Produto produto = produtos.get(i);
                System.out.println((i + 1) + ". " + produto.getNome() + " - R$" + produto.getPreco());
            }
        }
    }
}

class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
