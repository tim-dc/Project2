import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Passenger extends Thread{

    int passengerID, carID;

    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    Passenger(int passengerID) {
        this.passengerID = passengerID;
    }

    public void board(int carID) {

        // If car has invoked load
//        for(int i=0; i< )

    }

    public void unboard(int carID) {

        // If car has invoked unload
    }

    private void wander() {
        try{
            Thread.sleep(Math.round(Math.random() * 1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void joinQueue(int passengerID){
        Driver.line.add(this);
        System.out.println(dateTime.format(formatter) + " Passenger #" + passengerID + " Joined the Queue");
    }

    public void run() {

        // Wait (wander)
        wander();              // Passenger wanders around for a random time
        this.joinQueue(this.passengerID); // Get in Queue

        // Temporary
//        long a = Math.round(Math.random());
//        if(a%2 == 0){
//            this.joinQueue(this.passengerID);
//        }else{
//            wander();
//            this.joinQueue(this.passengerID);
//        }
//
//        for(int i =0; i < Driver.line.size();i++){
            // This would be replaced by cars
//            System.out.println("Queue " + Driver.line.remove());
//        }
    }



    public int getPassengerID() {
        return passengerID;
    }

    public int getCarID() {
        return carID;
    }
}
