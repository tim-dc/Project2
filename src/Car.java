import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Car extends Thread {
	
	int capacity, identifier;

	private int currLoad;
	static ArrayList<Passenger> pCar = new ArrayList<Passenger>();

	Car(int identifier, int capacity) {
		this.identifier = identifier;
		this.capacity = capacity;		//4
	}

	public void load() throws InterruptedException{
		//put in passengers
		for(int i = 0; i <= this.capacity; i++) {
			//add passenger here
			pCar.add(new Passenger(i));
			if(i==this.capacity) {
				//car starts running
				doAction(" is at capacity");
				//take a bit longer to travel
				System.out.println("Car " + this.identifier + " is on an adventure with " + pCar.size());
				Thread.sleep(((int) (Math.random() * 1000)));
			}
		}
	}

	public void unload() throws InterruptedException{
		//car stops running
		doAction(" has stopped");
		//car unloads passengers
		doAction(" may unload passengers");
		//drop passenger here
		pCar.removeAll(pCar);
	}

	private void doAction(String action) throws InterruptedException {
		System.out.println("Car " + this.identifier + action);
		Thread.sleep(((int) (Math.random() * 100)));
	}

	@Override
	public void run() {
		try{
			while (true) {
				doAction(" can be loaded");
				load();
				unload();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
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
}
