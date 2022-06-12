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

    public void run() {

        // Wait (wander)
//        wander();

        long a = Math.round(Math.random());
        if(a%2 == 0){
            System.out.println(a);
            Driver.line.add(this);
        }else{
            try{
                Thread.sleep(Math.round(Math.random()) * 1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            // Get in Line
            Driver.line.add(this);
        }

        for(int i =0; i < Driver.line.size();i++){
            // This would be replaced by cars
            System.out.println("Queue " + Driver.line.remove());
        }
    }



    public int getPassengerID() {
        return passengerID;
    }

    public int getCarID() {
        return carID;
    }
}
