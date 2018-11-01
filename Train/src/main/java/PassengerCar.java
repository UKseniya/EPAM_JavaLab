import java.util.Objects;

public class PassengerCar extends Carriage{
    int seats;


    public PassengerCar() {
        setType(CarriageType.PassengerCar);
    }

    public PassengerCar(int id, int weight) {
        super(id, weight);
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerCar that = (PassengerCar) o;
        return seats == that.seats;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), seats);
    }
}
