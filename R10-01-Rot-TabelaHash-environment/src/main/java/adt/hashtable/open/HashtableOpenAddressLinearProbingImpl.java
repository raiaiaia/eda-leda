package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddress;
import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if(this.isFull()) throw new HashtableOverflowException();
		if(element != null && search(element) == null) {
			int probTimes=0;
			boolean insert = false;
			while(probTimes < this.table.length && insert == false){
				int hashCode = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probTimes);
				if(this.table[hashCode] == null || this.table[hashCode].equals(deletedElement)){
					this.table[hashCode] = element;
					this.elements++;
					insert = true;
				} else {
					probTimes++;
					this.COLLISIONS++;
				}
			}	
		}
	}

	@Override
	public void remove(T element) {
		if(!this.isEmpty() && element != null){
			int probTimes=0;
			boolean found = false;
			while(probTimes < this.table.length && found == false){
				int hashCode = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probTimes);
				if(this.table[hashCode] != null) {
				    if(this.table[hashCode].equals(element)){
						this.table[hashCode] = this.deletedElement;
						this.elements--;
						found = true;
						if(probTimes >= 1) this.COLLISIONS--;
					}	
				} 
				probTimes++;
			}
		}
	}

	@Override
	public T search(T element) {
		T out = null;
		if(!this.isEmpty() && element != null){
			boolean found = false;
			int probTimes=0;
			while(probTimes < this.table.length && found == false){
				int hashCode = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probTimes);
				if(this.table[hashCode] != null) {
					if(this.table[hashCode].equals(element)){
						out = (T) this.table[hashCode];
						found = true;
					}
				}
				probTimes++;
			}
		}
		return out;
	}

	@Override
	public int indexOf(T element) {
		int out = -1;
		if(!this.isEmpty() && element != null){
			int probTimes=0;
			boolean found = false;
			while(found == false && probTimes < this.table.length){
				int hashCode = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probTimes);
				if(this.table[hashCode].equals(element)){
					out = hashCode;
					found = true;
				} else {
					probTimes++;
				}
			}
		}
		return out;
	}

}