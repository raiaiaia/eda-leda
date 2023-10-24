package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		if(array != null) {
			for (Integer element : array) 
    			insert(element);	 
		}
		return floor(this.root, numero, null);	
	}

	private Integer floor(BSTNode<Integer> actualRoot, double numero, Integer floor){
		if (!actualRoot.isEmpty()) {
			if (numero > actualRoot.getData()) 
				floor = floor((BSTNode<Integer>) actualRoot.getRight(), numero, actualRoot.getData());
			else if (numero < actualRoot.getData())
				floor = floor((BSTNode<Integer>) actualRoot.getLeft(), numero, floor);
			else
				floor = actualRoot.getData();
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		if(array != null) {
			for (Integer element : array) 
    			insert(element);	 
		}
		return ceil(this.root, numero, null);
	}

	private Integer ceil(BSTNode<Integer> actualRoot, double numero, Integer ceil) {
		if (!actualRoot.isEmpty()) {
			if (numero < actualRoot.getData()) 
				ceil = floor((BSTNode<Integer>) actualRoot.getRight(), numero, actualRoot.getData());
			else if (numero > actualRoot.getData())
				ceil = ceil((BSTNode<Integer>) actualRoot.getLeft(), numero, ceil);
			else
				ceil = actualRoot.getData();
		}
		return ceil;
	}
}
