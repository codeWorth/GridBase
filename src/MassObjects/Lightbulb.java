package MassObjects;

public class Lightbulb extends Wire {

	public Lightbulb(int _x, int _y) {
		super(_x, _y);
	}
	
	@Override
	public void outputToAll(){
	}
	
	@Override
	public String print(){
		return power.print();
	}
	
	@Override
	public boolean shouldAddOutlet(){
		return false;
	}
}
