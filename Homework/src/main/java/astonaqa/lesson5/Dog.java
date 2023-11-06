package astonaqa.lesson5;

public class Dog extends Animals {
    public static int dogCount=0;
    public Dog(String name) {
        super(name, 500, 10);
        dogCount++;
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
        if (swimLim > 0 && distance <= swimLim) {
            System.out.println(name + " swimming " + distance + " m.");
        } else {
            System.out.println(name + " cant swimming " + distance + " m.");
        }
    }
    public static int getDogCount() {
        return dogCount;
    }
}


