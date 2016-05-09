package MassObjects;

import MasslessObjects.Wood;
import Utitlity.Inlet;

public class WoodStore extends Store<Wood> {

	public WoodStore(int _x, int _y) {
		super(_x, _y, new Wood(0));
	}

	@Override
	public void outputToAll() {
		int outletsLength = outlets.size();
		double amountPer = stored.amount/outletsLength;
		
		stored.empty();
		
		for (Inlet<?> outlet : outlets){
				Inlet<Wood> thisOutlet = (Inlet<Wood>) outlet;
				thisOutlet.addToStore(new Wood(amountPer));
		}
	}

	@Override
	public void add(Wood toAdd) {
		stored.add(toAdd);
	}

}
