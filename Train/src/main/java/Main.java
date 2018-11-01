import java.util.ArrayList;
import java.util.List;

public class Main {

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
        Train train1 = new Train(1440);
        List<Carriage> carriages1 = new ArrayList<>();
        PassengerCar passengerCar = new PassengerCar(1, 80);
        PostCar postCar = new PostCar(1, 50);
        Locomotive locomotive = new Locomotive(1, 130, 17000);

        int passengerCarNumber = (train1.getTrainWeight() - locomotive.weight - postCar.weight)/passengerCar.weight;

        for(int i = 0; i < passengerCarNumber; i++){
            PassengerCar car = new PassengerCar();
            carriages1.add(car);
        }
        Locomotive locomotive1 = new Locomotive();
        PostCar postCar1 = new PostCar();
        carriages1.add(locomotive1);
        carriages1.add(postCar1);
        train1.setCarriages(carriages1);

        System.out.println(train1.toString());

        Train train2 = new Train(1450);
        List<Carriage> carriages2 = new ArrayList<>();
        Wagon wagon = new Wagon(1, 100);

        int wagonNumber = (train2.getTrainWeight() - locomotive.weight - postCar.weight)/wagon.weight;

        for(int i = 0; i < wagonNumber; i++){
            Wagon car = new Wagon();
            carriages2.add(car);
        }

        Locomotive locomotive2 = new Locomotive();
        PostCar postCar2 = new PostCar();
        carriages2.add(locomotive2);
        carriages2.add(postCar2);
        train2.setCarriages(carriages2);

        System.out.println(train2.toString());

    }
}
