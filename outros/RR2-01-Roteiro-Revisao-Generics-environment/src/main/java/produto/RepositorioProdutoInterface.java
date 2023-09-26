package produto;

public interface RepositorioProdutoInterface<T extends Produto> {
    
    boolean existe(int codigo);
    void inserir(T  produto);
    void atualizar(T  produto);
    void remover(int codigo);
    Produto procurar(int codigo);
}