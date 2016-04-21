package Inlets;

import MasslessObjects.MasslessObject;
import Utitlity.Outlet;

public abstract class Inlet {
	public static int MAX_ID = 1;
	
	private MasslessObject store;
	private Outlet input;
	
	private int id = Inlet.MAX_ID++;
	
	public Inlet(Outlet _input){
		input = _input;
	}

	public abstract MasslessObject removeStore();
	
	public void addToStore(MasslessObject inputObj){
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
	    
	    Inlet otherInlet = (Inlet) obj;
	    if (this.id == otherInlet.id){
	    	return true;
	    }
	    
	    return false;
	}
}
