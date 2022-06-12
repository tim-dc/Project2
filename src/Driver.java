import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Driver {

	static Passenger passengers[];
	static Queue<Passenger> line = new LinkedList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n, C, m;
		Scanner scan = new Scanner(System.in);
		ArrayList<Car> cars = new ArrayList<Car>();

		
		ArrayList<Semaphore> LoadingArea = new ArrayList<Semaphore>();
		ArrayList<Semaphore> UnLoadingArea = new ArrayList<Semaphore>();
		
		System.out.print("Enter the number of passenger processes: ");
		n = scan.nextInt();


		// Instantiate Passengers
		passengers = new Passenger[n];

		for(int i = 0; i < n; i++){
			passengers[i] = new Passenger(i);
		}


		for(int i = 0; i < n; i++){
			System.out.println("Passenger #" + passengers[i].getPassengerID());
			passengers[i].start();
		}

		System.out.println("--QUEUE--");



		
//		System.out.print("Enter the capacity of the car: ");
//		C = scan.nextInt();
//
//		System.out.print("Enter the number of cars: ");
//		m = scan.nextInt();
//
//		System.out.printf("Enter n: %d " + "Enter C: %d " + "Enter m: %d ", n, C, m);
		
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
