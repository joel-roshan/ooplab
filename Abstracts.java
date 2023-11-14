import java.util.Scanner;
abstract class Shape {
    public abstract int numberOfSides();
}

class Rectangle extends Shape {
    @Override
    public int numberOfSides() {
        return 4;
    }
}

class Triangle extends Shape {
    @Override
    public int numberOfSides() {
        return 3;
    }
}

class Hexagon extends Shape {
    @Override
    public int numberOfSides() {
        return 6;
    }
}

class Abstracts{

    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        Shape triangle = new Triangle();
        Shape hexagon = new Hexagon();

        System.out.println("Number of sides in a rectangle: " + rectangle.numberOfSides());
        System.out.println("Number of sides in a triangle: " + triangle.numberOfSides());
        System.out.println("Number of sides in a hexagon: " + hexagon.numberOfSides());
    }
}
