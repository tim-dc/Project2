public class Passenger extends Thread{

    int passengerID, carID;

    Passenger(int passengerID) {
        this.passengerID = passengerID;
    }

    public void board(int carID) {

    }

    public void unboard(int carID) {

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
        System.out.println("Passenger #" + passengerID + " Joined the Queue");
    }

    public void run() {

        // Wait (wander)
//        wander();              // Passenger wanders around for a random time
//        this.joinQueue(this.passengerID); // Get in Queue

        // Temporary
        long a = Math.round(Math.random());
        if(a%2 == 0){
            this.joinQueue(this.passengerID);
        }else{
            wander();
            this.joinQueue(this.passengerID);
        }

        for(int i =0; i < Driver.line.size();i++){
            // This would be replaced by cars
//            System.out.println("Queue " + Driver.line.remove());
        }
    }



    public int getPassengerID() {
        return passengerID;
    }

    public int getCarID() {
        return carID;
    }
}
