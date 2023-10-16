package adt.bst;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return this.root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.getRoot());
	}

	private int height(BSTNode<T> node){
		int out = -1;
		if(!node.isEmpty()){
			out = 1 + this.height((BSTNode<T>) node.getLeft()) + this.height((BSTNode<T>) node.getRight());
		} 
		return out;
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> out = new BSTNode<T>();
		if(element != null) out = search(element, this.getRoot());
		return out;
	}

	private BSTNode<T> search(T element, BSTNode<T> node) {
		BSTNode<T> out = new BSTNode<T>();
		if(node.isEmpty() || node.getData().equals(element)) {
			out = node;
		} else {
			if(element.compareTo(node.getData()) < 0)
				out = search(element, (BSTNode<T>) node.getLeft());
			else
				out = search(element, (BSTNode<T>) node.getRight());
		}
		return out;
	}

	@Override
	public void insert(T element) {
		if(element != null) insert(element, this.getRoot());
	}

	private void insert(T element, BSTNode<T> node) {
		if(node.isEmpty())  {
			node.setData(element);
			node.setRight(new BSTNode<T>());
			node.setLeft(new BSTNode<T>());
			node.getRight().setParent(node);
			node.getLeft().setParent(node);
		} else {
			if (element.compareTo(node.getData()) > 0)
				insert(element, (BSTNode<T>) node.getRight());
			else if (element.compareTo(node.getData()) < 0) 
				insert(element, (BSTNode<T>) node.getLeft());
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return maximum(this.getRoot());
	}

	private BSTNode<T> maximum(BSTNode<T> node){
		BSTNode<T> out = null;
		if(!node.isEmpty()){
			if(node.getRight().isEmpty()) out = node;
			else out = maximum( (BSTNode<T>) node.getRight());
		}
		return out;
	}

	@Override
	public BSTNode<T> minimum() {
		return minimum(this.getRoot());
	}

	private BSTNode<T> minimum(BSTNode<T> node){
		BSTNode<T> out = null;
		if(!node.isEmpty()){
			if(node.getLeft().isEmpty()) out = node;
			else out = minimum((BSTNode<T>) node.getLeft());
		}
		return out;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> out = null;
		if(element != null) {
			BSTNode<T> node = search(element);
			if(!node.isEmpty()){
				if(!node.getRight().isEmpty())
					out = minimum((BSTNode<T>) node.getRight());
				else
					out = sucessor(element, (BSTNode<T>) node.getParent());	
			}
		}
		return out;
	}

	private BSTNode<T> sucessor(T element, BSTNode<T> node) {
		BSTNode<T> out = new BSTNode<T>();	
		if(!node.isEmpty()){
			if(node.getData().compareTo(element) > 0) out = node;
			else out = sucessor(element, (BSTNode<T>) node.getParent());
		}
		return out;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> out = null;
		if(element != null) {
			BSTNode<T> node = search(element);
			if(!node.isEmpty()){
				if(!node.getLeft().isEmpty())
					out = minimum( (BSTNode<T>) node.getLeft());
				else
					out = predecessor(element, (BSTNode<T>) node.getParent());
			}
		}
		return out;
	}

	private BSTNode<T> predecessor(T element, BSTNode<T> node) {
		BSTNode<T> out = new BSTNode<T>();
		if(node == null || node.getData().compareTo(element) < 0){
			out = node;
		} else {
			out = predecessor(element, (BSTNode<T>) node.getParent());
		}
		return out;
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			BSTNode<T> node = search(element);
			if (!node.isEmpty()) {
				if (node.isLeaf()) {
					if (node == this.getRoot()) {
						this.root = new BSTNode<T>();
					} else {
						BSTNode<T> nodeParent = (BSTNode<T>) node.getParent();
						if (node.getData().compareTo(nodeParent.getData()) < 0) {
							nodeParent.setLeft(new BSTNode<T>());
						} else {
							nodeParent.setRight(new BSTNode<T>());
						}
					}
				} else if (node.getRight().isEmpty()) {
					promoteChild(node, (BSTNode<T>) node.getLeft());
				} else if (node.getLeft().isEmpty()) {
					promoteChild(node, (BSTNode<T>) node.getRight());
				} else {
					BSTNode<T> successor = sucessor(node.getData());
					remove(successor.getData());
					node.setData(successor.getData());
				}
			}
		}
	}

	private void promoteChild(BSTNode<T> parent, BSTNode<T> child) {
		if (parent == this.getRoot()) {
			this.root = child;
			child.setParent(new BSTNode<T>());
		} else {
			BSTNode<T> nodeParent = (BSTNode<T>) parent.getParent();
			if (parent.getData().compareTo(nodeParent.getData()) < 0) {
				nodeParent.setLeft(child);
			} else {
				nodeParent.setRight(child);
			}
		}
	}


	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
