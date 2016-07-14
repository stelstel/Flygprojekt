package flyace;
import view.ShowFlight;
import javax.swing.JFrame;

public class Fly implements Runnable {
	
	public String planeName = "";
	
	public Fly(String name) {
		this.planeName = name;
		Thread flyThread = new Thread(this);
		flyThread.start();
		
	}
	
	@Override
	public void run() {

		ShowFlight flight = new ShowFlight(planeName);
		flight.runLoop();
		System.exit(0);
		
	}
}
