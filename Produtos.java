public class Produtos{

    public String produto;
    public double quantidade;
    public double preco;

    public void addProdutos(int estoque) {
        this.quantidade += estoque;
    }
    public void subProdutos(int estoque) {
        this.quantidade -= estoque;
    }
}