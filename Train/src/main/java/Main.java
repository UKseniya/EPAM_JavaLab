import java.util.ArrayList;
import java.util.List;

public class Main {
    // Cоздаем константы, определяющие вес вагонов и поезда
    public static final int LOCOMOTIVE_POWER = 17000;
    public static final int LOCOMOTIVE_WEIGHT = 130;
    public static final int PASSENGER_CAR_WEIGHT = 80;
    public static final int WAGON_CAR_WEIGHT = 100;
    public static final int POST_CAR_WEIGHT = 50;
    public static final int RESTAURANT_CAR_WEIGHT = 80;


    public static void main(String[] args) {

        // Создаем поезда
        Train passengerTrain = assembleTrain(LOCOMOTIVE_POWER, LOCOMOTIVE_WEIGHT, CarriageType.PASSENGER_CAR);
        Train wagonTrain = assembleTrain(LOCOMOTIVE_POWER, LOCOMOTIVE_WEIGHT, CarriageType.WAGON);

        System.out.println(passengerTrain.toString());
        System.out.println(wagonTrain.toString());

    }
    // Метод, в котором находим количество вагонов в поезде без локомотива для грузового состава + без почтового
    // для пассажирского состава

    public static int getCarriageNumber(int trainWeight, int locomotiveWeight, int carriageWeight, CarriageType type) {
        int carNumber = 0;
        if ( type == CarriageType.WAGON){
            carNumber = (trainWeight - LOCOMOTIVE_WEIGHT) / carriageWeight;
        }
        else {
            carNumber = (trainWeight - LOCOMOTIVE_WEIGHT - POST_CAR_WEIGHT - RESTAURANT_CAR_WEIGHT) / carriageWeight;
        }

        return carNumber;
    }

    // Метод, в котором создаем список вагонов одного типа

    public static List<Carriage> createCarriagesList(int carNumber, CarriageType type) {
        List<Carriage> carriages = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            Carriage car = new Carriage();
            car.setType(type);
            carriages.add(car);
        }

        Carriage locomotive = new Carriage(CarriageType.LOCOMOTIVE);
        carriages.add(locomotive);
        if ( type == CarriageType.PASSENGER_CAR){
            Carriage postCar = new Carriage(CarriageType.POST_CAR);
            Carriage restaurant = new Carriage(CarriageType.RESTAURANT_CAR);
            carriages.add(postCar);
            carriages.add(restaurant);
        }
        return carriages;
    }

    // Метод, в котором собираем поезд
    public static Train assembleTrain (int locomotivePower, int locomotiveWeight, CarriageType type){
        int trainWeight = Train.calculateTrainWeight(locomotivePower, locomotiveWeight);
        int carWeight = 0;
        if ( type == CarriageType.PASSENGER_CAR ){
            carWeight = PASSENGER_CAR_WEIGHT;
        }
        else {
            carWeight = WAGON_CAR_WEIGHT;
        }

        int passengerCarNumber = getCarriageNumber(trainWeight, LOCOMOTIVE_WEIGHT, carWeight, type);
        Train train = new Train();
        List<Carriage> carriages = createCarriagesList(passengerCarNumber, type);
        train.setCarriages(carriages);
        return train;
    }
}
