import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Driver {

	static Passenger passengers[];
	static Car cars[];
	static Queue<Passenger> line = new LinkedList<>();
	static Queue<Car> carQueue = new LinkedList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numPassengers, capacity, numCars;
		Scanner scan = new Scanner(System.in);

		ArrayList<Semaphore> LoadingArea = new ArrayList<Semaphore>();
		ArrayList<Semaphore> UnLoadingArea = new ArrayList<Semaphore>();
		
		System.out.print("Enter the number of passenger processes: ");
		numPassengers = scan.nextInt();

		// Instantiate Passengers
		passengers = new Passenger[numPassengers];

		for(int i = 0; i < numPassengers; i++){
			passengers[i] = new Passenger(i);
		}

		for(int i = 0; i < numPassengers; i++){
			System.out.println("Passenger #" + passengers[i].getPassengerID());
		}

		System.out.print("Enter the capacity of the car: ");
		capacity = scan.nextInt();

		System.out.print("Enter the number of cars: ");
		numCars = scan.nextInt();

		// Instantiate Cars
		cars = new Car[numCars];

		for(int i = 0; i < numCars; i++) {
			cars[i] = new Car(capacity,i);
			carQueue.add(cars[i]);
//			System.out.println("CARS - " +cars[i]);
		}

		// Test
		for(int i=0; i< numCars; i++){
			System.out.println("Car #" + carQueue.remove().getId()+ " with capacity of: " + capacity);
		}

		// Add passengers to Queue
		for(int i = 0; i < numPassengers; i++){
			passengers[i].start();
		}

		// If passenger queue is enough for max capacity

		// Loop
		if(line.size() >= capacity){
			// set car to load
			for(int i = 0; i < capacity; i++){
				System.out.println("Passenger " + line.remove() + "has boarded");
			}

			System.out.println("Remaining passengers = " + line.size());
		}



//		for(int i = 0; i < m - 1; i++) {
//			cars.add(new Car(C, i));
//		}
//
//		for(int j = 0; j < m; j++) {
//			LoadingArea.add(new Semaphore());
//		}
//
//		for(int k = 0; k < m; k++) {
//			UnLoadingArea.add(new Semaphore());
//		}





	}

}
