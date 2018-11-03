import java.util.Objects;

public class Wagon extends Carriage{
    private String category;

    public Wagon() {
        setType(CarriageType.WAGON);
    }

    public Wagon(int id, int weight) {
        super(id, weight);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Wagon wagon = (Wagon) o;
        return Objects.equals(category, wagon.category);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), category);
    }
}
