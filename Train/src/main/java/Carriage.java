import java.util.Objects;

public class Carriage {
    private int id;
    private int weight;
    private CarriageType type;

    public Carriage() {
    }

    public Carriage(CarriageType type) {
        this.type = type;
    }

    public Carriage(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarriageType getType() {
        return type;
    }

    public void setType(CarriageType type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carriage carriage = (Carriage) o;
        return id == carriage.id &&
                weight == carriage.weight;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, weight);
    }
}
