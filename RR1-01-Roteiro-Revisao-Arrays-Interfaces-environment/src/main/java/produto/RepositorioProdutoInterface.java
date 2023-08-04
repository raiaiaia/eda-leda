package produto;

public interface RepositorioProdutoInterface {
    
    boolean existe(int codigo);
    void inserir(Produto produto);
    void atualizar(Produto produto);
    void remover(int codigo);
    Produto procurar(int codigo);
}
