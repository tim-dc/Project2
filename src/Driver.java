import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Driver {

	static Passenger passengers[];
	//static Car cars[];
	static Queue<Passenger> line = new LinkedList<>();


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n, C, m;
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Semaphore> LoadingArea = new ArrayList<Semaphore>();
		ArrayList<Semaphore> UnLoadingArea = new ArrayList<Semaphore>();
		
		System.out.print("Enter the number of passenger processes: ");
		n = scan.nextInt();

		System.out.print("Enter the capacity of the car: ");
		C = scan.nextInt();

		System.out.print("Enter the number of cars: ");
		m = scan.nextInt();

		// Instantiate Passengers
		passengers = new Passenger[n];
		//cars = new Car[m];
		Queue<Car> cars = new LinkedList<Car>();

		for(int i = 0; i < n; i++){
			passengers[i] = new Passenger(i);
		}

		for(int i = 0; i < m; i++) {
			//cars[i] = new Car(i, C);
//			new Thread(new Car(i, C));
			//cars[i].start();
			Car car = new Car(i, C);
			car.start();
			cars.add(car);
		}

		for(int i = 0; i < n; i++){
			System.out.println(getTimeStamp() + " Passenger #" + passengers[i].getPassengerID());
			passengers[i].start();
		}

//		for(int i = 0; i < C; i++) {
//
//		}

	}

	private static String getTimeStamp() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		return dateTime.format(formatter);
	}

}
