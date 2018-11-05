import java.util.List;

public class Train {
    private List<Carriage> carriages;
    private double tension;
    private double slope;
    private int trainWeight;
    private Locomotive locomotive;
    private PostCar postCar;

    public Train() {
    }

    public Train(int trainWeight) {
        this.trainWeight = trainWeight;
    }

    public int getTrainWeight() {
        return trainWeight;
    }

    public void setTrainWeight(int trainWeight) {
        this.trainWeight = trainWeight;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public PostCar getPostCar() {
        return postCar;
    }

    public void setPostCar(PostCar postCar) {
        this.postCar = postCar;
    }

    public List<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(List<Carriage> carriages) {
        this.carriages = carriages;
    }


    public int getPassengerCarNumber(){
        int numberOfPassengerCars = 0;
        for(int i = 0; i < carriages.size(); i++){
            Carriage car = carriages.get(i);
           if (car.getType() == CarriageType.PASSENGER_CAR) {
               numberOfPassengerCars++;
            }
            //System.out.println(numberOfPassengerCars);
        }
        return numberOfPassengerCars;
    }

    public int getWagonNumber(){
        int numberOfWagons = 0;
        for(int i = 0; i < carriages.size(); i++){
            Carriage car = carriages.get(i);
            if (car.getType() == CarriageType.WAGON){
                numberOfWagons++;
            }
        }
        return numberOfWagons;
    }

    public int getLocomotiveNumber(){
        int numberOfLocomotive = 0;
        for(int i = 0; i < carriages.size(); i++){
            Carriage car = carriages.get(i);
            if (car.getType() == CarriageType.LOCOMOTIVE){
                numberOfLocomotive++;
            }
        }
        return numberOfLocomotive;
    }

    public int getPostCarNumber(){
        int numberOfPostCars = 0;
        for(int i = 0; i < carriages.size(); i++){
            Carriage car = carriages.get(i);
            if (car.getType() == CarriageType.POST_CAR){
                numberOfPostCars++;
            }
        }
        return numberOfPostCars;
    }

    @Override
    public String toString() {
        return "Train consists of " +
                " passenger cars:" + getPassengerCarNumber() +
                ", wagons:" + getWagonNumber() +
                ", locomotive:" + getLocomotiveNumber() +
                ", post car:" + getPostCarNumber();
    }
}
