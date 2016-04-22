package Utitlity;

import Inlets.Inlet;

public interface Connection<E extends Inlet> extends Outlet {
	FIXME
	
	public void canTransfer();
	public void setInlet(Inlet _inlet);
	public void removeInlet();
}
