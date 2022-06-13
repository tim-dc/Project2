import java.util.concurrent.Semaphore;

public class Car implements Runnable {
	
	private final int Capacity;
	private final int identifier;
	
	public Car(int Capacity, int identifier) {
		this.Capacity = Capacity;
		this.identifier	= identifier;
	}

	public void load(){

	}

	public void unload(){

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
}
