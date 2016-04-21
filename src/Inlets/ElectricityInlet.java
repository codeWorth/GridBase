package Inlets;

import MasslessObjects.Electricity;
import Utitlity.Outlet;

public class ElectricityInlet extends Inlet {
	private Electricity store = new Electricity(0);
	
	public ElectricityInlet(Outlet _owner) {
		super(_owner);
	}

	@Override
	public Electricity removeStore() {
		Electricity temp = this.store;
		this.store = new Electricity(0);
		return temp;
	}

}
