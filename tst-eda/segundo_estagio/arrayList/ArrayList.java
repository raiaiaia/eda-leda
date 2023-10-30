package arrayList;

public class ArrayList {

    private Aluno[] lista;
    public static final int CAPACIDADE_DEFAULT = 20;
    private int indiceUltimo;
    
    public ArrayList() {
        this(CAPACIDADE_DEFAULT);
    }
    
    public ArrayList(int capacidade) {
        this.lista = new Aluno[capacidade];
        this.indiceUltimo = -1;
    }

    public int size() {
        return this.indiceUltimo + 1;
    }

    private boolean isFull(){
        return this.indiceUltimo == this.lista.length-1;
    }

    private void assegureCapacidade(int capacidadePretendida) {
        if(isFull()) resize(Math.max(this.lista.length * 2, capacidadePretendida));
    }  

    private void resize(int capacidade){
        Aluno[] novaLista = new Aluno[capacidade];

        int i = 0;
        while(i < capacidade) {
            novaLista[i] = this.lista[i];
            i++;
        }
        this.lista = novaLista;
        this.indiceUltimo = i;
    }   

    private void shifParaDireita(int index) {
        for(int i = this.indiceUltimo; i >= index; i--) 
            this.lista[i+1] = this.lista[i];
    }
    
    private void shiftParaEsquerda(int index) {
        for(int i = index; i < this.indiceUltimo; i++) 
            this.lista[i] = this.lista[i-1];
    }

    //adicionar no final 
    public boolean add(Aluno aluno) {
        assegureCapacidade(this.size() + 1);
        this.indiceUltimo++;
        this.lista[indiceUltimo] = aluno;
        return true; 
    }

    //adiciona recebendo o indice
    public void add(int index, Aluno aluno) {
        if( index < 0 || index > indiceUltimo )
            throw new IndexOutOfBoundsException();
        
        assegureCapacidade(this.size()+ 1);
        shifParaDireita(index);

        this.lista[index] = aluno;
        this.indiceUltimo++;
    }

    //modifica o valor em um determinado indice
    public void set(int index, Aluno aluno) {
        if( index < 0 || index > this.indiceUltimo) 
            throw new IndexOutOfBoundsException();
        
        this.lista[index] = aluno;
    }
    
    //remove um elemento dado um indice
    public Aluno remove(int index)  {
        if( index < 0 || index > this.indiceUltimo ) 
            throw new IndexOutOfBoundsException();
        
        Aluno aluno =  this.lista[index];
        shiftParaEsquerda(index);
        this.indiceUltimo--;
        return aluno;
    } 

    //busca por um aluno e o remove
    public boolean remove(Aluno aluno) {
        if(aluno != null) {
           int i = indexOf(aluno);
           if(i>-1) this.remove(i);
           return true;
        }
        return false;
    }

    //remove o ultimo elemento da lista
    public Aluno removeLast(Aluno aluno) {
        if(this.indiceUltimo == -1) return null;
        return this.lista[this.indiceUltimo--];
    }

    //busca pelo indice
    public Aluno get(int index) {
        if( index < 0 || index > this.indiceUltimo ) 
            throw new IndexOutOfBoundsException();

        return this.lista[index];
    }

    //busca pelo objeto
    public int indexOf(Aluno aluno) {
        int resp = -1;
        if(aluno != null){
            for(int i=0; i<this.size(); i++) {
                if(this.lista[i].equals(aluno)){
                    resp = i;
                }
            }
        }
        return resp;
    }

    //contem num elemento
    public boolean contains(Aluno aluno) {
        return this.indexOf(aluno) != -1;
    }
}  