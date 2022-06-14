import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Car extends Thread {
	
	private final int capacity;
	private final int identifier;
	private int currLoad;
	static ArrayList<Passenger> pCar = new ArrayList<Passenger>();
	
	public Car(int capacity, int identifier) {
		this.capacity = capacity;
		this.identifier	= identifier;
		currLoad = 0;
	}

	public void load(){
		// Car invoked load
		for(int i = 0; i < capacity; i++){
			Passenger passID = Driver.line.remove();
			pCar.add(passID);
			System.out.println("Passenger " + passID.getPassengerID() + "has boarded");
		}

// If passenger queue is enough for max capacity
//		while(line.size() >= capacity){
//			System.out.println("Queue Size- " + line.size());
//
//			// Remove front of queue
//			Car currCar = carQueue.remove();
//
//			// Start loading passengers
//			cars[0].start();
//
//			// Put it at the back
//			carQueue.add(currCar);
//		}

	}

	public void unload(){
		// Car invoked unload

	}

	@Override
	public void run() {
		// if car == load
		load();

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
		return capacity;
	}
}
