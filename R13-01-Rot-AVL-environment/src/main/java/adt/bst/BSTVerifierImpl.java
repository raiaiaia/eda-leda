package adt.bst;

import adt.bt.BTNode;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		return getBSt().isEmpty() || isBST(getBSt().getRoot());
	}
    private boolean isBST(BSTNode<T> node) {
		boolean isBST = true;

		if (!node.isEmpty()) {
			if (isValidLeft(node) && isValidRight(node)) {
				isBST = isBST((BSTNode<T>) node.getLeft()) && isBST((BSTNode<T>) node.getRight());
			} else {
				isBST = false;
			}
		}
		return isBST;
	}

	private boolean isValidLeft (BTNode<T> node) {
        return this.isValidLeft(node.getLeft(), node);
    }

	private boolean isValidLeft (BTNode<T> node, BTNode<T> root) {
        boolean resp = true;
        if (!node.isEmpty())
            if (node.getData().compareTo(root.getData()) < 0)
                resp = this.isValidLeft(node.getLeft(), root) && this.isValidLeft(node.getRight(), root);
            else
                resp = false;
        return resp;
	}

    private boolean isValidRight (BTNode<T> node) {
        return this.isValidRight(node.getRight(), node);
    }
	
	private boolean isValidRight (BTNode<T> node, BTNode<T> root) {
        boolean resp = true;
        if (!node.isEmpty())
            if (node.getData().compareTo(root.getData()) > 0)
                resp = this.isValidRight(node.getLeft(), root) && this.isValidRight(node.getRight(), root);
            else
                resp = false;   
        return resp;
    }
}
