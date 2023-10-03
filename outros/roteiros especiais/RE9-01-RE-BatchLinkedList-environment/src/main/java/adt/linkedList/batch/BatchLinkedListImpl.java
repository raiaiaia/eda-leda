package adt.linkedList.batch;

import org.w3c.dom.Node;

import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;
import util.GenericException;

/**
 * Manipula elementos da LinkedList em bloco (batch).
 * 
 * ATENÇÃO: NAO MODIFIQUE NENHUMA OUTRA CLASSE ALEM DESTA !!!!! 
 * 
 * @author campelo
 * @author adalberto
 *
 * @param <T>
 */
public class BatchLinkedListImpl<T> extends DoubleLinkedListImpl<T> implements BatchLinkedList<T> {

	/* 
	 * Nao modifique nem remova este metodo.
	 */
	public BatchLinkedListImpl() {
		head = new DoubleLinkedListNode<T>();
		last = (DoubleLinkedListNode<T>)head;
	}

	
	@Override
	public void inserirEmBatch(int posicao, T[] elementos) throws GenericException {
		DoubleLinkedListNode<T> aux1 = (DoubleLinkedListNode<T>) this.getHead();
		DoubleLinkedListNode<T> aux2 = (DoubleLinkedListNode<T>) this.getHead();
		
		int tamanho = tamanhoList(aux1);

		System.out.println(aux1.getData());
		System.out.println(length(aux1));

		if(posicao < 0 || posicao > tamanho || elementos == null) {
			throw new GenericException();
		} else {
			for(int i=0; i < posicao-1; i++) 
				aux2 = (DoubleLinkedListNode<T>) aux2.getNext();
			
			DoubleLinkedListNode<T> aux3 = (DoubleLinkedListNode<T>) aux2.getNext();
			DoubleLinkedListNode<T> headBatch = transformaLista(elementos);

			if(aux2.getNext().isNIL()){
				aux2.setNext(headBatch);
				headBatch.setPrevious(aux2.getPrevious());

				while(!headBatch.getNext().isNIL()) 
				headBatch = (DoubleLinkedListNode<T>) headBatch.getNext();

				headBatch.setNext(new DoubleLinkedListNode<>());
				this.setLast(new DoubleLinkedListNode<T>());
			} else {
			
				aux2.setNext(headBatch);
				headBatch.setPrevious(aux2.getPrevious());

				while(!headBatch.getNext().isNIL()) 
					headBatch = (DoubleLinkedListNode<T>) headBatch.getNext();
				
				while(!aux3.isNIL()){
					headBatch.setNext(aux3);
					aux3.setPrevious(headBatch);
					aux3 = (DoubleLinkedListNode<T>) aux3.getNext();
					headBatch = (DoubleLinkedListNode<T>) headBatch.getNext();
					System.out.println(toStringFromHead());
					System.out.println(toStringFromLast());

				}	
			}
		}
	}

	@Override
	public void removerEmBatch(int posicao, int quantidade) throws GenericException {
		DoubleLinkedListNode<T> auxTamanho = (DoubleLinkedListNode<T>) this.getHead();
		int tamanho = tamanhoList(auxTamanho);

		if(posicao < 0 || posicao > tamanho ||  quantidade < 0 ) {

		}
	}

	private int length(DoubleLinkedListNode<T> head) {
        int i = 0;
        while (!head.isNIL()) {
            head = (DoubleLinkedListNode<T>) head.getNext();
            i++;
        }
        return i;
    }

	private DoubleLinkedListNode<T> transformaLista(T[] elementos){
		DoubleLinkedListNode<T> res = new DoubleLinkedListNode<T>();
		DoubleLinkedListNode<T> aux3 = new DoubleLinkedListNode<T>();
		for(int k=0; k<elementos.length; k++) {
			aux3.setData(elementos[k]);
			aux3.setNext(new DoubleLinkedListNode<T>());
			if(k == 0){
				res = aux3;
				aux3.setPrevious(new DoubleLinkedListNode<T>());
			} else {
				DoubleLinkedListNode<T> auxTemp = new DoubleLinkedListNode<T>();
				auxTemp.setData(elementos[k-1]);
				aux3.setPrevious(auxTemp);
			} 
			aux3 = (DoubleLinkedListNode<T>) aux3.getNext();
		}
		return res;
	}

	private int tamanhoList(DoubleLinkedListNode<T> aux){
		int res = 0;
		while(!aux.isNIL()){
			res++;
			aux = (DoubleLinkedListNode<T>) aux.getNext();
		}
		return res;
	}
	
	
	/* 
	 * NAO MODIFIQUE NEM REMOVA ESTE METODO!!!
	 * 
	 * Use este metodo para fazer seus testes
	 * 
	 * Este metodo monta uma String contendo os elementos do primeiro ao ultimo, 
	 * comecando a navegacao pelo Head
	 */
	public String toStringFromHead() {
		
		String result = "";
		DoubleLinkedListNode<T> aNode = (DoubleLinkedListNode<T>)getHead();
		
		while(!aNode.isNIL()) {
			
			if (!result.isEmpty()) {
				result += " ";
			}
				
			result += aNode.getData();
			aNode = (DoubleLinkedListNode<T>) aNode.getNext();
			
		}
		
		return result;
	}
	
	/* 
	 * NAO MODIFIQUE NEM REMOVA ESTE METODO!!!
	 * 
	 * Use este metodo para fazer seus testes
	 * 
	 * Este metodo monta uma String contendo os elementos do primeiro ao ultimo, 
	 * porem comecando a navegacao pelo Last
	 * 
	 * Este metodo produz o MESMO RESULTADO de toStringFromHead() 
	 * 
	 */
	public String toStringFromLast() {
		
		String result = "";
		DoubleLinkedListNode<T> aNode = getLast();
		
		while(!aNode.isNIL()) {
			
			if (!result.isEmpty()) {
				result = " " + result;
			}
				
			result = aNode.getData() + result;
			aNode = (DoubleLinkedListNode<T>) aNode.getPrevious();
			
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return toStringFromHead();
	}


}
