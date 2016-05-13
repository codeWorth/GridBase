package MasslessObjects;

public class Energy extends MasslessObject {
	public static final double efficiency = 1;
	
	public Energy(double _amount) {
		super(_amount);
	}
	
	public void transmit(){
		amount *= efficiency;
	}
	
	@Override
	public double empty(){
		transmit();
		return super.empty();
	}
}
