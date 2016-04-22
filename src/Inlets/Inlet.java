package Inlets;

import MasslessObjects.MasslessObject;
import Utitlity.Outlet;

public abstract class Inlet<E extends MasslessObject> {	
	public static int MAX_ID = 1;
	
	private E store;
	private Outlet input;
	
	private int id = Inlet.MAX_ID++;

	public Inlet(Outlet _input){
		input = _input;
	}

	public E removeStore(){
		E temp = (E) this.store.empty();
		return temp;
	}
	
	public void addToStore(E inputObj){
		if (inputObj.getClass().equals(this.getClass())){
			this.store.add(inputObj);
		}
	}
	
	public void removeThis(){
		input.removeOutlet(this);
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj){
	        return true;
	    } else if (obj == null) {
	        return false;
	    } else if (!(obj instanceof Inlet)){
	        return false;
	    }
	    
	    Inlet<?> otherInlet = (Inlet<?>) obj;
	    if (this.id == otherInlet.id){
	    	return true;
	    }
	    
	    return false;
	}
}
