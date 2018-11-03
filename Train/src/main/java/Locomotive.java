import java.util.Objects;

public class Locomotive extends Carriage {
    //public enum LocomotiveType{ Steam, Diesel, Electric };
    private int power;
    private int capacity;


    public Locomotive() {
        setType(CarriageType.LOCOMOTIVE);
    }

    public Locomotive(int id, int weight, int power) {
        super(id, weight);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Locomotive that = (Locomotive) o;
        return power == that.power &&
                capacity == that.capacity;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), power, capacity);
    }
}
