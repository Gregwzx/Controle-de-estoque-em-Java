import java.util.ArrayList; // importando ArrayList
import java.util.Scanner;   // importando Scanner

// Classe Produto
class Produto {
    String nome;
    int quantidade;
    double preco;

    // Construtor
    public Produto(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // Para adicionar estoque
    public void addProdutos(int qtd) {
        this.quantidade += qtd;
    }

    // Para remover estoque (com validação)
    public boolean subProdutos(int qtd) {
        if (this.quantidade >= qtd) {
            this.quantidade -= qtd;
            return true;
        }
        return false;
    }

    // Para exibir informações do produto 
    public void exibirProduto() {
        System.out.println("Nome: " + nome +
                " | Quantidade: " + quantidade +
                " | Preço: R$" + preco); // Aparece R$ automaticamente
    }
}

// Classe principal
public class Programa {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Lista de todos os produtos
        ArrayList<Produto> estoque = new ArrayList<>();

        int opcao;

        // Loop do menu 
        do {
            System.out.println("\n===== CONTROLE DE ESTOQUE =====");
            System.out.println("1 - Cadastrar novo produto");
            System.out.println("2 - Adicionar estoque");
            System.out.println("3 - Remover estoque (venda)");
            System.out.println("4 - Listar produtos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    // Cadastrar produto
                    System.out.print("Digite o nome do produto: ");
                    String nome = teclado.nextLine();

                    System.out.print("Digite a quantidade: ");
                    int qtd = teclado.nextInt();

                    System.out.print("Digite o preço: ");
                    double preco = teclado.nextDouble();

                    Produto novoProduto = new Produto(nome, qtd, preco);
                    estoque.add(novoProduto);

                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    // Adicionar estoque
                    System.out.print("Digite o nome do produto: ");
                    nome = teclado.nextLine();

                    Produto p = buscarProduto(estoque, nome);
                    if (p != null) {
                        System.out.print("Quantidade a adicionar: ");
                        qtd = teclado.nextInt();
                        p.addProdutos(qtd);
                        System.out.println("Estoque atualizado com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;

                case 3:
                    // Remover estoque (venda)
                    System.out.print("Digite o nome do produto: ");
                    nome = teclado.nextLine();

                    p = buscarProduto(estoque, nome);
                    if (p != null) {
                        System.out.print("Quantidade a remover: ");
                        qtd = teclado.nextInt();
                        if (p.subProdutos(qtd)) {
                            System.out.println("Venda realizada com sucesso!");
                        } else {
                            System.out.println("Estoque insuficiente!");
                        }
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;

                case 4:
                    // Listar produtos
                    System.out.println("\n=== ESTOQUE ATUAL ===");
                    for (Produto prod : estoque) {
                        prod.exibirProduto();
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        teclado.close();
    }

    // Para buscar um produto pelo nome
    public static Produto buscarProduto(ArrayList<Produto> estoque, String nome) {
        for (Produto p : estoque) {
            if (p.nome.equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }
}
