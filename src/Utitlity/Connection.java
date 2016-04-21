package Utitlity;

import Inlets.ElectricityInlet;

public interface Connection extends Outlet {
	public void canTransfer();
	public void setInlet(ElectricityInlet _inlet);
	public void removeInlet();
}
