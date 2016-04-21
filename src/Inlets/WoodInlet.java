package Inlets;

import MasslessObjects.Wood;
import Utitlity.Outlet;

public class WoodInlet extends Inlet{
	private Wood store = new Wood();

	public WoodInlet(Outlet _owner) {
		super(_owner);
	}

	@Override
	public Wood removeStore() {
		Wood temp = this.store;
		this.store = new Wood();
		return temp;
	}
	
}
