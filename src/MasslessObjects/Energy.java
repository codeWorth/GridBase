package MasslessObjects;

public class Energy extends MasslessObject {
	public static final double efficiency = 0;
	public double amount = 0;
	
	public Energy(double _amount) {
		amount = _amount;
	}
	
	public void transmit(double dist){
		double multiplier = Math.pow(efficiency, dist);
		amount *= multiplier;
	}
}
