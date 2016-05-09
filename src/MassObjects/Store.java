package MassObjects;

import MasslessObjects.MasslessObject;
import Utitlity.Inlet;
import Utitlity.Outlet;

public abstract class Store<E extends MasslessObject> extends Outlet {

	protected E stored;
	
	public Store(int _x, int _y, E _store) {
		super(_x, _y, 1, 1);
		
		stored = (E) _store.clone();
	}
	
	@Override
	protected boolean shouldAddOutlet() {
		return true;
	}
	
	@Override
	protected boolean handleAddOutlet(Inlet<?> out){
		if (out.type().equals(stored.getClass())){
			outlets.add(out);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public double print() {
		return stored.amount;
	}

	public abstract void add(E toAdd);
}
