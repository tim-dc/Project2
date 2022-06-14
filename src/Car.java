import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Car extends Thread {
	
	private final int Capacity;
	private final int identifier;
	private int currLoad;
	static ArrayList<Passenger> pCar = new ArrayList<Passenger>();
	
	public Car(int Capacity, int identifier) {
		this.Capacity = Capacity;
		this.identifier	= identifier;
		currLoad = 0;
	}


	public void load(){
		// Car invoked load

	}

	public void unload(){
		// Car invoked unload

	}

	@Override
	public void run() {

	}

	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	//Semaphore
	public static void LoadArea(Semaphore x) {
		try {
			x.acquire();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public static void UnloadArea(Semaphore x) {
		try {
			x.release();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public int getCurrLoad() {
		return currLoad;
	}

	public void setCurrLoad(int currLoad) {
		this.currLoad = currLoad;
	}

	public int getCapacity() {
		return Capacity;
	}
}
