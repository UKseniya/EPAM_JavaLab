import java.util.Objects;

public class PostCar extends Carriage{
    private int capacity;

    public PostCar() {
        setType(CarriageType.POST_CAR);
    }

    public PostCar(int id, int weight) {
        super(id, weight);
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
        PostCar postCar = (PostCar) o;
        return capacity == postCar.capacity;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), capacity);
    }
}
