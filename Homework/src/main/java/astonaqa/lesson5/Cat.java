package astonaqa.lesson5;

public class Cat extends Animals {
    private static int catCount=0;
    private static boolean isFull=false;
    public Cat(String name) {
        super(name, 200, 0);
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= runLim) {
            System.out.println(name + " running " + distance + " m.");
        } else {
            System.out.println(name + " cant running " + distance + " m.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " cant swimming");
    }
    public static int getCatCount() {
        return catCount;
    }
    public void eat(Plate plate) {
        if (isFull) {
            System.out.println(name + " is full.");
            return;
        }

        if (plate.decreaseFood(10)) {
            isFull = true;
            System.out.println(name + " ate and full now.");
        } else {
            System.out.println(name + " add food for eat");
        }
    }

    public boolean isFull() {
        return isFull;
    }
}
