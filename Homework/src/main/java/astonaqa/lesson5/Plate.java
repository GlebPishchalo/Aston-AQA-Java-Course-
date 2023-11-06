package astonaqa.lesson5;


    class Plate {
        private int food;

        public Plate(int food) {
            this.food = food;
        }

        public void addFood(int amount) {
            if (amount > 0) {
                food += amount;
                System.out.println("Add " + amount + " feed");
            }
        }

        public boolean decreaseFood(int amount) {
            if (food >= amount) {
                food -= amount;
                return true;
            }
            return false;
        }

        public int getFood() {
            return food;
        }
        public void info() {
            System.out.println("in plate: " + getFood() + " feed");
        }
    }

