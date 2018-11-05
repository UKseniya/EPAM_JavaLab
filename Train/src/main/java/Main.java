import java.util.ArrayList;
import java.util.List;

public class Main {
    // Cоздаем константы, определяющие вес вагонов и поезда
    public static final int TRAIN_WEIGHT = 1450;
    public static final int LOCOMOTIVE_WEIGHT = 130;
    public static final int PASSENGER_CAR_WEIGHT = 80;
    public static final int WAGON_CAR_WEIGHT = 100;
    public static final int POST_CAR_WEIGHT = 50;

    /* Вес поезда = (сила тяги локомотива - (сопротивление+наибольший уклон)* вес локомотива) / (сопротивление + наибольший уклон
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

    public static void main(String[] args) {
        // Создаем поезда
        Train passengerTrain = createTrain(TRAIN_WEIGHT, CarriageType.PASSENGER_CAR);
        Train wagonTrain = createTrain(TRAIN_WEIGHT, CarriageType.WAGON);

        System.out.println(passengerTrain.toString());
        System.out.println(wagonTrain.toString());

    }
    // Метод, в котором находим количество вагонов в поезде без локомотива для грузового состава + без почтового
    // для пассажирского состава

    public static int getCarriageNumber(int trainWeight, int locomotiveWeight, int carriageWeight, CarriageType type) {
        int carNumber = (TRAIN_WEIGHT - LOCOMOTIVE_WEIGHT) / carriageWeight;;
        if ( type == CarriageType.WAGON){
            carNumber = (TRAIN_WEIGHT - LOCOMOTIVE_WEIGHT) / carriageWeight;
        }
        else {
            carNumber = (TRAIN_WEIGHT - LOCOMOTIVE_WEIGHT - POST_CAR_WEIGHT) / carriageWeight;
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
        Locomotive locomotive = new Locomotive();
        carriages.add(locomotive);
        if ( type == CarriageType.PASSENGER_CAR){
            PostCar postCar = new PostCar();
            carriages.add(postCar);
        }
        return carriages;
    }

    // Метод, в котором собираем поезд
    public static Train createTrain (int trainWeight, CarriageType type){
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
