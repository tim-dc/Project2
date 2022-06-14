import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
		System.out.println("Capacity = " + capacity + " Queue Size = " + Driver.line.size());
		boolean isFull = false;
		int counter = 0;

//		for(int i = 0; i < this.capacity; i++) {
		do{
			if(Driver.line.size() >= this.capacity ) {
				// Add passengers
				for(int j = 0; j < this.capacity; j++){
					Passenger p = Driver.line.remove();
					pCar.add(p);
					System.out.println(getTimeStamp() + " Passenger # " + p.getPassengerID()+ " joined Car " + this.identifier);
				}
				System.out.println("----- PCar ----- " + pCar.size());
				System.out.println("remaining passengers: " + Driver.line.size());
				//car starts running
				doAction(" is at capacity");
				//take a bit longer to travel
				System.out.println(getTimeStamp() + " Car " + this.identifier + " is on an adventure with " + pCar.size());
				Thread.sleep(((int) (Math.random() * 1000)));
				isFull = true;
			}

//			if(counter)

		}while (isFull !=  true);


//		}
	}

	public void unload() throws InterruptedException{
		//car stops running
		doAction(" has stopped");
		//car unloads passengers
		doAction(" may unload passengers");
		//drop passenger here
		System.out.println("Current pCar  Size = " + pCar.size());
		pCar.removeAll(pCar);
		System.out.println("pCar after Clear Size = " + pCar.size());
	}

	private void doAction(String action) throws InterruptedException {
		System.out.println(getTimeStamp() + "Car " + this.identifier + action);
		Thread.sleep(((int) (Math.random() * 1000)));
	}

	private String getTimeStamp() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		return dateTime.format(formatter);
	}

	@Override
	public void run() {
		try{
			while (true) {
//				if(capacity == Driver.line.size()){
					doAction(" can be loaded");
					load();
					unload();
//				}
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
