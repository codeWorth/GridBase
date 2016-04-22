package MasslessObjects;

public class Energy extends MasslessObject {
	public static final double efficiency = 0;
	public double amount = 0;
	
	public Energy(double _amount) {
		super(_amount);
	}
	
	public void transmit(double dist){
		double multiplier = Math.pow(efficiency, dist);
		amount *= multiplier;
	}
	
	@Override
	public Energy empty() {
		Energy temp = new Energy(this.amount);
		this.amount = 0;
		return temp;
	}
}
