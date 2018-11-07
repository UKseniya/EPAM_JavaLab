import java.util.List;

public class Train {
    private List<Carriage> carriages;
    private static double tension = 1.88;
    private static double slope = 9.5;


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

    public Train() {
    }


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

    public int getCarNumber(CarriageType type) {
        int numberOfCars = 0;
        for (int i = 0; i < carriages.size(); i++) {
            Carriage car = carriages.get(i);
            if (car.getType() == type) {
                numberOfCars++;
            }

        }
        return numberOfCars;
    }

    @Override
    public String toString() {
        if ( getCarNumber(CarriageType.PASSENGER_CAR) !=0){
            return "The train consists of" +
                    " Locomotives: " + getCarNumber(CarriageType.LOCOMOTIVE) +
                    ", Passenger Cars: " + getCarNumber(CarriageType.PASSENGER_CAR) +
                    ", Restaurant Cars: " + getCarNumber(CarriageType.RESTAURANT_CAR) +
                    ", Post Cars: " + getCarNumber(CarriageType.POST_CAR);
        }
        else {
            return "The train consists of" +
                    " Locomotives: " + getCarNumber(CarriageType.LOCOMOTIVE) +
                    ", Wagons: " + getCarNumber(CarriageType.WAGON);
        }
    }
}



