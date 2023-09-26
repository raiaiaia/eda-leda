package produto;

public class RepositorioProdutoArray implements RepositorioProdutoInterface {
    
	private Produto[] produtos;
	private int index = -1;

	public RepositorioProdutoArray(int size) {
		super();
		this.produtos = new Produto[size];
	}

    private int procurarIndice(int codigo) {
		for(int i=0; i<produtos.length; i++){
			if(produtos[i].getCodigo() == codigo){
				index = i;
			}
		}
		return index;
	}


    @Override
    public boolean existe(int codigo) {
        if(procurarIndice(codigo) != -1){
			return true;
		} 
		return false;
       
    }

    @Override
    public void inserir(Produto produto) {
        for(int i=0; i<produtos.length; i++){
			if(produtos[i] == null){
				produtos[i] = produto;
				break;
			}
		}
    }

    @Override
    public void atualizar(Produto produto) {
        int codigo = produto.getCodigo();
		
		if(existe(codigo)){
			index = this.procurarIndice(codigo);
			produtos[index] = null;
			produtos[index] = produto;
		} else{
			throw new NullPointerException("Produto inexistente na lista de produtos!");
		}
    }

    @Override
    public void remover(int codigo) {
        if(existe(codigo)){
			index = this.procurarIndice(codigo);
			produtos[index] = null;
		}else{
			throw new NullPointerException("Produto inexistente na lista de produtos!");
		}
    }

    @Override
    public Produto procurar(int codigo) {
        Produto p = null;

		for(int i=0; i<produtos.length; i++){
			if(produtos[i].getCodigo() == codigo){
				p = produtos[i];
			}
		}
		return p;
    }
    
}