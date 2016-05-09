package MasslessObjects;

public class Energy extends MasslessObject {
	public static final double efficiency = 0.95;
	
	public Energy(double _amount) {
		super(_amount);
	}
	
	public void transmit(){
		amount *= efficiency;
	}
	
	@Override
	public Energy empty(){
		transmit();
		return (Energy) super.empty();
	}
}
