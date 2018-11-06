import java.util.List;

public class Train {
    private List<Carriage> carriages;
    private static double tension = 1.88;
    private static double slope = 9.5;


    public Train() {
    }


    /* Вес поезда = (сила тяги локомотива - (сопротивление+наибольший уклон)* вес локомотива) / (сопротивление + наибольший уклон)
     * Например,
     * ТЭП70
     * вес = 130т
     * мощность = 4000л.с.
     * сила тяги = 17000т.с. при скорости 50км/ч
     * сила трения = 1,88
     * уклон = 9,5%
     *
     * Расчет:
     * при скорости 50км/ч
     * (17000 - (1,88+9,5) * 130)/(1,88+9,5) = 1440т - вес поезда.
     * Один вагон весит примерно 100т, следовательное 14 вагонов*/

    public static int calculateTrainWeight(int locomotivePower, int locomotiveWeight) {
        int trainWeight = 0;
        double weight = (locomotivePower - (tension + slope) * locomotiveWeight) / (tension + slope);
        trainWeight = (int) weight;
        return trainWeight;
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

    public int getRestaurantCarNumber(){
        int numberOfRestaurantCars = 0;
        for(int i = 0; i < carriages.size(); i++){
            Carriage car = carriages.get(i);
            if (car.getType() == CarriageType.RESTAURANT_CAR){
                numberOfRestaurantCars++;
            }
        }
        return numberOfRestaurantCars;
    }

    @Override
    public String toString() {
        if ( getPassengerCarNumber() != 0 ){
            return "The train consists of" +
                    " passenger cars:" + getPassengerCarNumber() +
                    ", restaurant:" + getRestaurantCarNumber() +
                    ", locomotive:" + getLocomotiveNumber() +
                    " and post car:" + getPostCarNumber();
        }
        else {
            return "The train consists of" +
                    " wagons:" + getWagonNumber() +
                    " and locomotive:" + getLocomotiveNumber();
        }
    }
}
