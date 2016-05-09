package Utitlity;

import MasslessObjects.MasslessObject;

public class Inlet<E extends MasslessObject> {		
	public static int MAX_ID = 1;
	
	private E store;
	private Connection owner1;
	private Outlet owner2;
	
	private int id = Inlet.MAX_ID++;
	
	public Inlet(E obj){
		store = (E) obj.clone();
	}
	
	public boolean canTransfer(){
		return owner1.canTransferFrom(owner2);
	}

	public E removeStore(){
		E temp = (E) this.store.empty();
		return temp;
	}
	
	public void addToStore(E inputObj){
		this.store.add(inputObj);
	}
	
	public boolean removeThis(){
		return (owner1.remove(this) && owner2.remove(this));
	}
	
	public boolean addOwner(Outlet own){
		if (own instanceof Connection){
			if (owner1 == null){
				owner1 = (Connection) own;
				return true;
			} 
		}
		
		if (owner2 == null){
			owner2 = own;
		} else {
			return false;
		}
		
		return true;
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
	
	public Class<?> type(){
		return store.getClass();
	}
	
	/**
	 * @return The Connection object which this inlet will output into.
	 */
	public Connection toPropagte(){
		return owner1;
	}
}
