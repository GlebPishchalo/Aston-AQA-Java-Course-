package astonaqa.lesson10;

import java.util.ArrayList;

class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();

    public float getWeight() {
        if (fruits.isEmpty()) {
            return 0.0f;
        }

        float fruitWeight = fruits.get(0) instanceof Apple ? 1.0f : 1.5f;
        return fruitWeight * fruits.size();
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public void transferFruits(Box<T> anotherBox) {
        if (this == anotherBox) {
            return;
        }
        if (!fruits.isEmpty() && anotherBox.fruits.size() > 0
                && fruits.get(0).getClass() != anotherBox.fruits.get(0).getClass()) {
            throw new IllegalArgumentException("U cant transfer diffrent fruits");
        }

        anotherBox.fruits.addAll(this.fruits);
        this.fruits.clear();

    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }
}