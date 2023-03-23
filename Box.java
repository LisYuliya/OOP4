import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Box<T extends Fruit> implements Iterable<T> {
    private List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public void moveTo(Box<? super T> otherBox) {
        if (this.getClass().equals(otherBox.getClass())) {
            otherBox.fruits.addAll(this.fruits);
            this.fruits.clear();
        }
    }

    public double getWeight() {
        return fruits.stream().mapToDouble(Fruit::getWeight).sum();
    }

    @Override
    public Iterator<T> iterator() {
        return fruits.iterator();
    }
}