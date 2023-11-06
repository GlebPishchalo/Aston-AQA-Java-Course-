package astonaqa.lesson5;

public abstract class Animals {
    protected String name;
    protected int runLim;
    protected int swimLim;
    private static int animalCount = 0;


    public Animals(String name, int runLim, int swimLim) {
        this.name = name;
        this.runLim = runLim;
        this.swimLim = swimLim;
        animalCount++;
    }

    public abstract void run(int distance);
    public abstract void swim(int distance);
    public static int getAnimalCount() {
        return animalCount;
    }
}

