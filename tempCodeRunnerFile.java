public static void setNumber(int num) {
        number = num;
    }

    public void run() {
        while (true) {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Cube of " + number + " is: " + (number * number * number));
            }
        }
    }
}

public class MultiThreadedProgram {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        ThreadSquare threadSquare = new ThreadSquare();
        ThreadCube threadCube = new ThreadCube();

        numberGenerator.start();
        threadSquare.start();
        threadCube.start();
    }
}
